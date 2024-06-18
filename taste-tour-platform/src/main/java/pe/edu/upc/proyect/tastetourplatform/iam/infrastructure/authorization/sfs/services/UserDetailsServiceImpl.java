package pe.edu.upc.proyect.tastetourplatform.iam.infrastructure.authorization.sfs.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.iam.infrastructure.authorization.sfs.model.UserDetailsImpl;
import pe.edu.upc.proyect.tastetourplatform.iam.infrastructure.persistence.jpa.repositories.UserGRepository;

/**
 * This class is responsible for providing the user details to the Spring Security framework.
 * It implements the UserDetailsService interface.
 */
@Service(value = "defaultUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserGRepository userGRepository;

  public UserDetailsServiceImpl(UserGRepository userGRepository) {
    this.userGRepository = userGRepository;
  }

  /**
   * This method is responsible for loading the user details from the database.
   * @param username The username.
   * @return The UserDetails object.
   * @throws UsernameNotFoundException If the user is not found.
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = userGRepository.findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found with username: " + username));
    return UserDetailsImpl.build(user);
  }
}
