package pe.edu.upc.proyect.tastetourplatform.user.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetAllCardsQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetCardByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.CardQueryService;
import pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories.CardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CardQueryServiceImpl implements CardQueryService {
    private final CardRepository cardRepository;

    public CardQueryServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    @Override
    public List<DebitCard> handle(GetAllCardsQuery query){
        return cardRepository.findAll();
    }

    @Override
    public Optional<DebitCard> handle(GetCardByIdQuery query){
        return cardRepository.findById(query.cardId());
    }
}
