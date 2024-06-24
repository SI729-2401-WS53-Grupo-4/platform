package pe.edu.upc.proyect.tastetourplatform.iam.application.internal.commandservices;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.iam.application.internal.outboundservices.hashing.HashingService;
import pe.edu.upc.proyect.tastetourplatform.iam.application.internal.outboundservices.tokens.TokenService;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.aggregates.UserG;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.commands.SignInCommand;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.commands.SignUpCommand;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.services.UserGCommandService;
import pe.edu.upc.proyect.tastetourplatform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import pe.edu.upc.proyect.tastetourplatform.iam.infrastructure.persistence.jpa.repositories.UserGRepository;

import java.util.Optional;

/**
 * User command service implementation
 * <p>
 *     This class implements the {@link UserGCommandService} interface and provides the implementation for the
 *     {@link SignInCommand} and {@link SignUpCommand} commands.
 * </p>
 */
@Service
public class UserGCommandServiceImpl implements UserGCommandService {

  private final UserGRepository userGRepository;
  private final HashingService hashingService;
  private final TokenService tokenService;

  private final RoleRepository roleRepository;

  public UserGCommandServiceImpl(UserGRepository userGRepository, HashingService hashingService,
                                 TokenService tokenService, RoleRepository roleRepository) {

    this.userGRepository = userGRepository;
    this.hashingService = hashingService;
    this.tokenService = tokenService;
    this.roleRepository = roleRepository;
  }

  /**
   * Handle the sign-in command
   * <p>
   *     This method handles the {@link SignInCommand} command and returns the user and the token.
   * </p>
   * @param command the sign-in command containing the username and password
   * @return and optional containing the user matching the username and the generated token
   * @throws RuntimeException if the user is not found or the password is invalid
   */
  @Override
  public Optional<ImmutablePair<UserG, String>> handle(SignInCommand command) {
    var user = userGRepository.findByUsername(command.username());
    if (user.isEmpty())
      throw new RuntimeException("User not found");
    if (!hashingService.matches(command.password(), user.get().getPassword()))
      throw new RuntimeException("Invalid password");

    var token = tokenService.generateToken(user.get().getUsername());
    return Optional.of(ImmutablePair.of(user.get(), token));
  }

  /**
   * Handle the sign-up command
   * <p>
   *     This method handles the {@link SignUpCommand} command and returns the user.
   * </p>
   * @param command the sign-up command containing the username and password
   * @return the created user
   */
  @Override
  public Optional<UserG> handle(SignUpCommand command) {
    if (userGRepository.existsByUsername(command.username()))
      throw new RuntimeException("Username already exists");
    var roles = command.roles().stream()
        .map(role ->
            roleRepository.findByName(role.getName())
                .orElseThrow(() -> new RuntimeException("Role name not found")))
        .toList();
    var user = new UserG(command.username(), hashingService.encode(command.password()), roles);
    userGRepository.save(user);
    return userGRepository.findByUsername(command.username());
  }
}
