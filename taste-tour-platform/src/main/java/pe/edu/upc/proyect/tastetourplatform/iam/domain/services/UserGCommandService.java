package pe.edu.upc.proyect.tastetourplatform.iam.domain.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.aggregates.UserG;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.commands.SignInCommand;
import pe.edu.upc.proyect.tastetourplatform.iam.domain.model.commands.SignUpCommand;

import java.util.Optional;

public interface UserGCommandService {
  Optional<ImmutablePair<UserG, String>> handle(SignInCommand command);
  Optional<UserG> handle(SignUpCommand command);
}
