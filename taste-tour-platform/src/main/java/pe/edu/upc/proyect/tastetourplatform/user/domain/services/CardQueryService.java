package pe.edu.upc.proyect.tastetourplatform.user.domain.services;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface CardQueryService {
    List<DebitCard> handle(GetAllCardsQuery query);
    Optional<DebitCard> handle(GetCardByIdQuery query);
}
