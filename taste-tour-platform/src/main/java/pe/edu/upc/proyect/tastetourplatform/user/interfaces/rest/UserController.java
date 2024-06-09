package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.DeleteUserCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.UserCommandService;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.UserQueryService;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.CreateUserResource;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.UpdateUserResource;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.UserResource;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform.UpdateUserCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform.UserResourceFromEntityAssembler;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/Api/TasteTour/User", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="User", description = "User Managment Endpoints")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService){
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource){
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);
        var userId = userCommandService.handle(createUserCommand);

        if (userId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers(){
        var getAllUsersQuery = new GetAllUsersQuery();
        var users = userQueryService.handle(getAllUsersQuery);
        var userResources= users.stream().map(UserResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(userResources);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id){
        var getUserByIdQuery = new GetUserByIdQuery(id);
        var user = userQueryService.handle(getUserByIdQuery);

        if (user.isEmpty())
            return ResponseEntity.badRequest().build();
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable Long id, @RequestBody UpdateUserResource updateUserResource){
        var updateUserCommand = UpdateUserCommandFromResourceAssembler.toCommandFromResource(id,updateUserResource);
        var updatedUser = userCommandService.handle(updateUserCommand);

        if(updatedUser.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(updatedUser.get());
        return ResponseEntity.ok(userResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        var deleteUserCommand = new DeleteUserCommand(id);
        userCommandService.handle(deleteUserCommand);
        return ResponseEntity.ok("User with given id successfully deleted ");
    }
}
