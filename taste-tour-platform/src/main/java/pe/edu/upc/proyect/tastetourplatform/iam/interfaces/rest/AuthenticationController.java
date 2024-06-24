package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.services.UserGCommandService;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.AuthenticatedUserResource;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.SignInResource;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.SignUpResource;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.resources.UserGResource;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.rest.transform.UserGResourceFromEntityAssembler;

import java.io.Console;

/**
 * AuthenticationController
 * <p>
 *     This controller is responsible for handling authentication requests.
 *     It exposes two endpoints:
 *     <ul>
 *         <li>POST /api/v1/auth/sign-in</li>
 *         <li>POST /api/v1/auth/sign-up</li>
 *     </ul>
 * </p>
 */
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoints")
public class AuthenticationController {

  private final UserGCommandService userGCommandService;

  public AuthenticationController(UserGCommandService userGCommandService) {
    this.userGCommandService = userGCommandService;
  }

  /**
   * Handles the sign-in request.
   * @param signInResource the sign-in request body.
   * @return the authenticated user resource.
   */
  @PostMapping("/sign-in")
  public ResponseEntity<AuthenticatedUserResource> signIn(
      @RequestBody SignInResource signInResource) {

    System.out.println(signInResource);
    var signInCommand = SignInCommandFromResourceAssembler
        .toCommandFromResource(signInResource);
    var authenticatedUser = userGCommandService.handle(signInCommand);
    if (authenticatedUser.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler
        .toResourceFromEntity(
            authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());


    return ResponseEntity.ok(authenticatedUserResource);
  }

  /**
   * Handles the sign-up request.
   * @param signUpResource the sign-up request body.
   * @return the created user resource.
   */
  @PostMapping("/sign-up")
  public ResponseEntity<UserGResource> signUp(@RequestBody SignUpResource signUpResource) {
    var signUpCommand = SignUpCommandFromResourceAssembler
        .toCommandFromResource(signUpResource);
    var user = userGCommandService.handle(signUpCommand);
    if (user.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    var userResource = UserGResourceFromEntityAssembler.toResourceFromEntity(user.get());
    return new ResponseEntity<>(userResource, HttpStatus.CREATED);
  }
}
