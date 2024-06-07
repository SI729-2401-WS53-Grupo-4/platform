package pe.edu.upc.proyect.tastetourplatform.tastetour.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.CreateUserCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.DeleteUserCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.User;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.UserCommandService;
import pe.edu.upc.proyect.tastetourplatform.tastetour.insfractructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateUserCommand command){
        User user = new User(
                command.firstName(),
                command.lastName(),
                command.password(),
                command.location(),
                command.birthdate(),
                command.email(),
                command.phone()
        );
        userRepository.save(user);
        return user.getId();
    }
    @Override
    public void handle(DeleteUserCommand command){
        userRepository.deleteById(command.userId());
        System.out.println("User Delete");
    }
}
