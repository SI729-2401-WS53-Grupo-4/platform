package pe.edu.upc.proyect.tastetourplatform.user.domain.services;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.*;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.entities.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
    Optional<User> handle (UpdateUserCommand command);
    void handle(DeleteUserCommand command);
}
