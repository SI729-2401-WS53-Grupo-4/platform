package pe.edu.upc.proyect.tastetourplatform.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.exceptions.UserNotFoundException;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.CreateUserCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.commands.DeleteUserCommand;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.User;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.UserCommandService;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services.UserQueryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Api/User")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService){
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userQueryService.handle(new GetAllUsersQuery());
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return Optional.ofNullable(userQueryService.handle(new GetUserByIdQuery(id))
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<Long> addUser(@RequestBody CreateUserCommand command) {
        Long userId = userCommandService.handle(command);
        return ResponseEntity.ok(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userCommandService.handle(new DeleteUserCommand(id));
    }
}
