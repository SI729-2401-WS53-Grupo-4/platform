package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.aggregates.UserG;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.entities.Role;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.UserGResource;

public class UserGResourceFromEntityAssembler {

  public static UserGResource toResourceFromEntity(UserG userG) {
    var roles = userG.getRoles().stream()
        .map(Role::getStringName)
        .toList();
    return new UserGResource(userG.getId(), userG.getUsername(), roles);
  }
}
