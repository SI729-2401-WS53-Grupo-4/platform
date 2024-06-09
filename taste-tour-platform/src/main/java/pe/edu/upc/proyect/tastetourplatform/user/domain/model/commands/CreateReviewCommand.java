package pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record CreateReviewCommand(Rating rating, Comment comment) {
}
