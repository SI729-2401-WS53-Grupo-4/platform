package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.*;

public record CreateReviewCommand(Rating rating, Comment comment) {
}
