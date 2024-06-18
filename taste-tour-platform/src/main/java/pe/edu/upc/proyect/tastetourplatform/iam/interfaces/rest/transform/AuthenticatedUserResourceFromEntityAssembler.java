package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.aggregates.UserG;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

  public static AuthenticatedUserResource toResourceFromEntity(UserG userG, String token) {
    return new AuthenticatedUserResource(userG.getId(), userG.getUsername(), token);
  }
}
