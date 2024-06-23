package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands;

public record AddBookingCommand(String title, String image, Integer duration, Float price) {
}
