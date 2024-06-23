package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record CreateReviewResource(Rating rating, Comment comment) {
}
