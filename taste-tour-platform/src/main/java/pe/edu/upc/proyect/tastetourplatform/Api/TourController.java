package pe.edu.upc.proyect.tastetourplatform.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates.Tour;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.AddTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetToursByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.TourCommandService;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.TourQueryService;

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
        return tourQueryService.handle(new GetToursByIdQuery(id));
    }
    @PostMapping("/create")
    public ResponseEntity<Long> addTour(@RequestBody AddTourCommand command) {
        Long tourId = tourCommandService.handle(command);
        return ResponseEntity.ok(tourId);
    }

    @DeleteMapping("/{id}")
    public void deleteTour(@PathVariable Long id){
        tourCommandService.handle(new DeleteTourCommand(id));
    }

}
