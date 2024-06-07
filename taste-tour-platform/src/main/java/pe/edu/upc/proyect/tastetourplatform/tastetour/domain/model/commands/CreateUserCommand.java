package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.*;

public record CreateUserCommand(FirstName firstName, LastName lastName, Password password, String location, String birthdate, String email, String phone) {
}
