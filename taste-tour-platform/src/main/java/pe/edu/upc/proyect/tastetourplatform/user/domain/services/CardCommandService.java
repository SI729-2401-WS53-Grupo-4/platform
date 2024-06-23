package pe.edu.upc.proyect.tastetourplatform.user.domain.services;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.*;

import java.util.Optional;

public interface CardCommandService {
    Long handle(AddCardCommand command);
    Optional<DebitCard> handle (UpdateCardCommand command);
    void handle(DeleteCardCommand command);
}
