package pe.edu.upc.proyect.tastetourplatform.iam.domain.services;

import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
  void handle(SeedRolesCommand command);
}
