package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.*;

public record UpdateTourCommand(Long tourId,
                                String titleTour,
                                String description,
                                Instructor instructor,
                                Rating rating,
                                Capacity capacity,
                                Duration duration,
                                String date,
                                Price price,
                                Long restauranteId) {
}
