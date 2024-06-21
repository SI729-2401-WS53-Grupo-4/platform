package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record UserResource(Long id, String firstName, String lastName, Password password, String location, String birthdate, String email, String phone) {
}
