package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands;

public record UpdateCardCommand(Long cardId, String num, String cvv, String date, String name) {
}
