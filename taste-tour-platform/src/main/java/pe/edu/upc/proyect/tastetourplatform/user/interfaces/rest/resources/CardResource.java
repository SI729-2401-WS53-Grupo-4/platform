package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

public record CardResource(Long id, NumCard numCard, Cvv cvv, String date, String name) {
}
