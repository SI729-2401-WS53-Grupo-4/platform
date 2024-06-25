package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.AddBookingDetailsCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.ReservaCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.ReservaResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.ReservaResourceFromEntityAssembler;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/booking", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Booking", description = "Booking Managment Endpoints")
public class BookingController {

    private final ReservaCommandService reservaCommandService;

    public BookingController(ReservaCommandService reservaCommandService) {
        this.reservaCommandService = reservaCommandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResource> getReservaDetails(@PathVariable Long id) {
        var AddBookingDetailsCommand = new AddBookingDetailsCommand(id);
        var reserva = reservaCommandService.handle(AddBookingDetailsCommand);

        var reservaResource = ReservaResourceFromEntityAssembler.toResourceFromEntity(reserva);
        return ResponseEntity.ok(reservaResource);
    }

}
