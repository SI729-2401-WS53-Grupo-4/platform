package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

import java.util.Date;

public record UpdateUserResource(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone) {
}
