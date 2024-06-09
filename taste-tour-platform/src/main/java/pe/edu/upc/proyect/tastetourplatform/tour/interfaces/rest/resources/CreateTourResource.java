package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.*;

public record CreateTourResource(String titleTour, String description, Instructor instructor, Rating rating, Capacity capacity, Duration duration, String date, Price price,Long restauranteId) {
}
