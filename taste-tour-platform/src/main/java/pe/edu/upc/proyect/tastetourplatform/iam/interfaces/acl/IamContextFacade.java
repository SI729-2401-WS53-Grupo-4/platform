package pe.edu.upc.proyect.tastetourplatform.iam.interfaces.acl;

import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.commands.SignUpCommand;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.entities.Role;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.services.UserGCommandService;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.services.UserGQueryService;

import java.util.ArrayList;
import java.util.List;

/**
 * IamContextFacade
 * <p>
 *     This class is a facade for the IAM context. It provides a simple interface for other
 *     bounded contexts to interact with the
 *     IAM context.
 *     This class is a part of the ACL layer.
 * </p>
 *
 */
public class IamContextFacade {

  private final UserGCommandService userGCommandService;
  private final UserGQueryService userGQueryService;

  public IamContextFacade(UserGCommandService userCommandService,
      UserGQueryService userQueryService) {
    this.userGCommandService = userCommandService;
    this.userGQueryService = userQueryService;
  }

  /**
   * Creates a user with the given username and password.
   * @param username The username of the user.
   * @param password The password of the user.
   * @return The id of the created user.
   */
  public Long createUser(String username, String password) {
    var signUpCommand = new SignUpCommand(username, password, List.of(Role.getDefaultRole()));
    var result = userGCommandService.handle(signUpCommand);
    if (result.isEmpty()) return 0L;
    return result.get().getId();
  }

  /**
   * Creates a user with the given username, password and roles.
   * @param username The username of the user.
   * @param password The password of the user.
   * @param roleNames The names of the roles of the user. When a role does not exist,
   *                  it is ignored.
   * @return The id of the created user.
   */
  public Long createUser(String username, String password, List<String> roleNames) {
    var roles = roleNames != null
        ? roleNames.stream().map(Role::toRoleFromName).toList()
        : new ArrayList<Role>();
    var signUpCommand = new SignUpCommand(username, password, roles);
    var result = userGCommandService.handle(signUpCommand);
    if (result.isEmpty())
      return 0L;
    return result.get().getId();
  }

  /**
   * Fetches the id of the user with the given username.
   * @param username The username of the user.
   * @return The id of the user.
   */
  public Long fetchUserIdByUsername(String username) {
    var getUserByUsernameQuery = new GetUserByUsernameQuery(username);
    var result = userGQueryService.handle(getUserByUsernameQuery);
    if (result.isEmpty())
      return 0L;
    return result.get().getId();
  }

  /**
   * Fetches the username of the user with the given id.
   * @param userId The id of the user.
   * @return The username of the user.
   */
  public String fetchUsernameByUserId(Long userId) {
    var getUserByIdQuery = new GetUserByIdQuery(userId);
    var result = userGQueryService.handle(getUserByIdQuery);
    if (result.isEmpty())
      return Strings.EMPTY;
    return result.get().getUsername();
  }
}
