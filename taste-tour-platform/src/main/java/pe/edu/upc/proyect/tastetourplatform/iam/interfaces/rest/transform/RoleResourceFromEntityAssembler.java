package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.entities.Role;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {

  public static RoleResource toResourceFromEntity(Role role) {
    return new RoleResource(role.getId(), role.getStringName());
  }
}
