package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands;

public record CreateUserCommand(String firstName, String lastName, String email, String phone, String date, String locale) {
}
