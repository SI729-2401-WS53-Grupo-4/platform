package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.*;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
    void handle(DeleteUserCommand command);
}
