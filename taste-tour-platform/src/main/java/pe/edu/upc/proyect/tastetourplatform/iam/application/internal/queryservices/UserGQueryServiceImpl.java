package pe.edu.upc.proyect.tastetourplatform.iam.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.aggregates.UserG;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetAllUsersQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.queries.GetUserByUsernameQuery;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.services.UserGQueryService;
import pe.edu.upc.proyect.tastetourplatform.iam.infrastructure.persistence.jpa.repositories.UserGRepository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link UserGQueryService} interface.
 */
@Service
public class UserGQueryServiceImpl implements UserGQueryService {
  private final UserGRepository userGRepository;

  /**
   * Constructor.
   *
   * @param userGRepository {@link UserGRepository} instance.
   */
  public UserGQueryServiceImpl(UserGRepository userGRepository) {
    this.userGRepository = userGRepository;
  }

  /**
   * This method is used to handle {@link GetAllUsersQuery} query.
   * @param query {@link GetAllUsersQuery} instance.
   * @return {@link List} of {@link UserG} instances.
   * @see GetAllUsersQuery
   */
  @Override
  public List<UserG> handle(GetAllUsersQuery query) {
    return userGRepository.findAll();
  }

  /**
   * This method is used to handle {@link GetUserByIdQuery} query.
   * @param query {@link GetUserByIdQuery} instance.
   * @return {@link Optional} of {@link UserG} instance.
   * @see GetUserByIdQuery
   */
  @Override
  public Optional<UserG> handle(GetUserByIdQuery query) {
    return userGRepository.findById(query.userId());
  }

  /**
   * This method is used to handle {@link GetUserByUsernameQuery} query.
   * @param query {@link GetUserByUsernameQuery} instance.
   * @return {@link Optional} of {@link UserG} instance.
   * @see GetUserByUsernameQuery
   */
  @Override
  public Optional<UserG> handle(GetUserByUsernameQuery query) {
    return userGRepository.findByUsername(query.username());
  }
}
