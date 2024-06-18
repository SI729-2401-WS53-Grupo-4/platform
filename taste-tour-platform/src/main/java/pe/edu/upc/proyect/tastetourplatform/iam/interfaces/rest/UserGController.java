package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.services.UserGQueryService;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.UserGResource;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform.UserGResourceFromEntityAssembler;

import java.util.List;

/**
 * This class is a REST controller that exposes the users resource.
 * It includes the following operations:
 * - GET /api/v1/users: returns all the users
 * - GET /api/v1/users/{userId}: returns the user with the given id
 **/
@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "User Management Endpoints")
public class UserGController {

  private final UserGQueryService userGQueryService;

  public UserGController(UserGQueryService userGQueryService) {
    this.userGQueryService = userGQueryService;
  }
  @GetMapping
  public ResponseEntity<List<UserGResource>> getAllUsers() {
    var getAllUsersQuery = new GetAllUsersQuery();
    var users = userGQueryService.handle(getAllUsersQuery);
    var userResources = users.stream()
        .map(UserGResourceFromEntityAssembler::toResourceFromEntity)
        .toList();
    return ResponseEntity.ok(userResources);
  }

  @GetMapping(value = "/{userId}")
  public ResponseEntity<UserGResource> getUserById(@PathVariable Long userId) {
    var getUserByIdQuery = new GetUserByIdQuery(userId);
    var user = userGQueryService.handle(getUserByIdQuery);
    if (user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    var userResource = UserGResourceFromEntityAssembler.toResourceFromEntity(user.get());
    return ResponseEntity.ok(userResource);
  }
}
