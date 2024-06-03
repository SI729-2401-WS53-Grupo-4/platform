package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates.Tour;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.*;

public record AddTourCommand(String titleTour, String description, Instructor instructor, Rating rating, Capacity capacity, Duration duration, String date, Price price) {
}
