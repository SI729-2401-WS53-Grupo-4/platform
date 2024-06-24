package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources;

import java.util.List;

public record UserGResource(Long id, String username, List<String> roles) {
}
