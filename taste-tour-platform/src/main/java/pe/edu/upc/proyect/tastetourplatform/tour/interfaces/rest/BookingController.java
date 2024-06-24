package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteBookingCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllReservationsQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.ReservaCommandService;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.ReservaQueryService;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.ReservaResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.ReservaResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/booking", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Booking", description = "Booking Managment Endpoints")
public class BookingController {
    private final ReservaCommandService reservaCommandService;
    private final ReservaQueryService reservaQueryService;

    public BookingController(ReservaCommandService reservaCommandService, ReservaQueryService reservaQueryService) {
        this.reservaCommandService = reservaCommandService;
        this.reservaQueryService = reservaQueryService;
    }

    @Operation(summary = "Obtener lista de reserva")
    @GetMapping
    public ResponseEntity<List<ReservaResource>> getAllBooking(){
        var getAllReservationsQuery = new GetAllReservationsQuery();
        var bookings = reservaQueryService.handle(getAllReservationsQuery);
        var bookingResource = bookings.stream().map(ReservaResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(bookingResource);
    }
    @Operation(summary = "Eliminar una reserva por Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id){
        var deleteBookingCommand = new DeleteBookingCommand(id);
        reservaCommandService.handle(deleteBookingCommand);
        return ResponseEntity.ok("Reservation canceled");
    }

}
