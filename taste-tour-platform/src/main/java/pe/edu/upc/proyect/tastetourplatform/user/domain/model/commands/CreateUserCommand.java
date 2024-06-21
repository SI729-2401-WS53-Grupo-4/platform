package pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record CreateUserCommand(String firstName, String lastName, Password password, String location, String birthdate, String email, String phone) {
}
