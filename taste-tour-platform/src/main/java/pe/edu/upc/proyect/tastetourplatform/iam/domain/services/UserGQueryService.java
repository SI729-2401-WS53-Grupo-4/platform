package pe.edu.upc.proyect.tastetourplatform.iam.domain.services;

import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.aggregates.UserG;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserGQueryService {
  List<UserG> handle(GetAllUsersQuery query);
  Optional<UserG> handle(GetUserByIdQuery query);
  Optional<UserG> handle(GetUserByUsernameQuery query);
}
