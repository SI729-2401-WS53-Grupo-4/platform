package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/booking", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Booking", description = "Booking Managment Endpoints")
public class BookingController {
}
