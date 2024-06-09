package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourCommandService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/Restaurant")
public class RestaurantController {
    private final TourCommandService tourCommandService;

    public RestaurantController(TourCommandService tourCommandService) {
        this.tourCommandService = tourCommandService;
    }
}
