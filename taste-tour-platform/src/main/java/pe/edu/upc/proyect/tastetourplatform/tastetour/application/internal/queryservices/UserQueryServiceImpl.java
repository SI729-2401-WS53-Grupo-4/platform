package pe.edu.upc.proyect.tastetourplatform.tastetour.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.User;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.UserQueryService;
import pe.edu.upc.proyect.tastetourplatform.tastetour.insfractructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersQuery query){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query){
        return userRepository.findById(query.userId());
    }
}
