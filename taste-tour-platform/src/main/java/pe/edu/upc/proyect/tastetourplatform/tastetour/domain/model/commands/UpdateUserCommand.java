package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands;

public record UpdateUserCommand(Long id, String firstName, String lastName, String password, String location, String birthdate, String email, String phone) {
}