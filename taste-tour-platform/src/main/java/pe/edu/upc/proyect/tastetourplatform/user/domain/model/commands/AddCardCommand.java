package pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands;

public record AddCardCommand(Long numCard, Long cvv, String date, String name) {
}
