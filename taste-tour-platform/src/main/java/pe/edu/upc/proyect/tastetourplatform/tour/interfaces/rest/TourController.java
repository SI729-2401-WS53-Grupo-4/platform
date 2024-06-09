package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.exceptions.TourNotFoundException;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddRestaurantToTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetToursByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourQueryService;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.CreateTourResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.TourResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.UpdateTourResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.CreateTourCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.TourResourceFromEntityAssembler;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.UpdateTourCommandFromResourceAssembler;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/Api/TasteTour/Tour", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Tour", description = "Tour Managment Endpoints")
public class TourController {
    private final TourCommandService tourCommandService;
    private final TourQueryService tourQueryService;

    public TourController(TourCommandService tourCommandService, TourQueryService tourQueryService){
        this.tourCommandService = tourCommandService;
        this.tourQueryService = tourQueryService;
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

    @GetMapping
    public ResponseEntity<List<TourResource>> getAllTours(){
        var getAllToursQuery = new GetAllToursQuery();
        var tours = tourQueryService.handle(getAllToursQuery);
        var tourResources= tours.stream().map(TourResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(tourResources);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TourResource> getTourById(@PathVariable Long id){
        var getTourByIdQuery = new GetToursByIdQuery(id);
        var tour = tourQueryService.handle(getTourByIdQuery);

        if (tour.isEmpty())
            return ResponseEntity.badRequest().build();
        var tourResource = TourResourceFromEntityAssembler.toResourceFromEntity(tour.get());
        return ResponseEntity.ok(tourResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TourResource> updateTour(@PathVariable Long id, @RequestBody UpdateTourResource updateTourResource){
        var updateTourCommand = UpdateTourCommandFromResourceAssembler.toCommandFromResource(id,updateTourResource);
        var updatedTour = tourCommandService.handle(updateTourCommand);

        if(updatedTour.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var tourResource = TourResourceFromEntityAssembler.toResourceFromEntity(updatedTour.get());
        return ResponseEntity.ok(tourResource);
    }

    @PostMapping("/{Id}/restaurant")
    public ResponseEntity<Long> addRestaurantToTour(@PathVariable Long Id, @RequestBody Long restauranteId) {
        AddRestaurantToTourCommand command = new AddRestaurantToTourCommand(Id, restauranteId);
        Long updatedTourId = tourCommandService.handle(command);
        return ResponseEntity.ok(updatedTourId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTour(@PathVariable Long id){
        var deleteTourCommand = new DeleteTourCommand(id);
        tourCommandService.handle(deleteTourCommand);
        return ResponseEntity.ok("Tour with given id successfully deleted ");
    }

}
