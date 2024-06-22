package pe.edu.upc.proyect.tastetourplatform.user.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.AddCardCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.DeleteCardCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.UpdateCardCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.CardCommandService;
import pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories.CardRepository;

import java.util.Optional;

@Service
public class CardCommandServiceImpl implements CardCommandService {
    private final CardRepository cardRepository;

    public CardCommandServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    @Override
    public Long handle(AddCardCommand command){
        DebitCard debitCard = new DebitCard(
                command.numCard(),
                command.cvv(),
                command.date(),
                command.name()
        );
        cardRepository.save(debitCard);
        return debitCard.getId();
    }

    @Override
    public Optional<DebitCard> handle(UpdateCardCommand command) {
        var result = cardRepository.findById(command.cardId());
        if (result.isEmpty())
            throw new IllegalArgumentException("Card does not exist");
        var cardToUpdated = result.get();
        try{
            var updatedCard = cardRepository.save(cardToUpdated.updatedInformation(command.numCard(),command.cvv(), command.date(),command.name()));
            return Optional.of(updatedCard);
        } catch (Exception e){
            throw new IllegalArgumentException("Error while updating card: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteCardCommand command){
        cardRepository.deleteById(command.cardId());
        System.out.println("Card Delete");
    }
    
}
