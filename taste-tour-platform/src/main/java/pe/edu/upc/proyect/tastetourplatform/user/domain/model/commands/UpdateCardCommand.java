package pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record UpdateCardCommand(Long cardId, Long numCard, Long cvv, String date, String name) {
}
