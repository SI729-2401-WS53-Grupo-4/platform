package pe.edu.upc.proyect.tastetourplatform.user.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.CreateUserCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.Password;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.UserCommandService;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.UserQueryService;

@Service
public class UserContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    /* public Long createUser(String firstName, String lastName, Password password, String location, String birthdate, String email, String phone){
        var createUserCommand = new CreateUserCommand(firstName, lastName, password, location, birthdate, email, phone);
        var user = userCommandService.handle(createUserCommand);
        if (user.isEmpty())
            return 0L;
        return user.get().getId();
    }*/

}
