package pe.edu.upc.proyect.tastetourplatform.user.domain.services;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.entities.User;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
}
