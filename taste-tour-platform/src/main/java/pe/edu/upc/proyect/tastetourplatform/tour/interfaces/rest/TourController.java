package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.exceptions.TourNotFoundException;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetToursByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourQueryService;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.CreateTourResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.TourResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.CreateTourCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.TourResourceFromEntityAssembler;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/Tour")
public class TourController {
    private final TourCommandService tourCommandService;
    private final TourQueryService tourQueryService;

    public TourController(TourCommandService tourCommandService, TourQueryService tourQueryService){
        this.tourCommandService = tourCommandService;
        this.tourQueryService = tourQueryService;
    }

    @GetMapping
    public List<Tour> getAllTours(){
        return tourQueryService.handle(new GetAllToursQuery());
    }

    @GetMapping("/{id}")
    public Optional<Tour> getTourById(@PathVariable Long id){
        return Optional.ofNullable(tourQueryService.handle(new GetToursByIdQuery(id))
                .orElseThrow(() -> new TourNotFoundException(id)));
    }
    @PostMapping("/create")
    public ResponseEntity<TourResource> createTour(@RequestBody CreateTourResource createTourResource){
        var createTourCommand = CreateTourCommandFromResourceAssembler.toCommandFromResource(createTourResource);
        var tourId = tourCommandService.handle(createTourCommand);

        if (tourId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getTourByIdQuery = new GetToursByIdQuery(tourId);
        var tour = tourQueryService.handle(getTourByIdQuery);

        if (tour.isEmpty())
            return ResponseEntity.badRequest().build();
        var tourResource = TourResourceFromEntityAssembler.toResourceFromEntity(tour.get());
        return new ResponseEntity<>(tourResource, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Long id){
        tourCommandService.handle(new DeleteTourCommand(id));
    }

}
