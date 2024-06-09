package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record UpdateUserResource(FirstName firstName, LastName lastName, Password password, String location, String birthdate, String email, String phone) {
}
