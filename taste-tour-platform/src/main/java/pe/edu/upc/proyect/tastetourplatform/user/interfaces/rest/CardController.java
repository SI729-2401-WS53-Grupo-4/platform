package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.DeleteCardCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetAllCardsQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetCardByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.CardCommandService;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.CardQueryService;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.*;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/debitCard", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="DebitCard", description = "DebitCard Managment Endpoints")
public class CardController {
    private final CardCommandService cardCommandService;
    private final CardQueryService cardQueryService;

    public CardController(CardCommandService cardCommandService, CardQueryService cardQueryService){
        this.cardCommandService = cardCommandService;
        this.cardQueryService = cardQueryService;
    }

    @PostMapping("/create")
    public ResponseEntity<CardResource> addCard(@RequestBody AddCardResource addCardResource){
        var addCardCommand = AddCardCommandFromResourceAssembler.toCommandFromResource(addCardResource);
        var cardId = cardCommandService.handle(addCardCommand);

        if (cardId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getCardByIdQuery = new GetCardByIdQuery(cardId);
        var card = cardQueryService.handle(getCardByIdQuery);

        if (card.isEmpty())
            return ResponseEntity.badRequest().build();
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(card.get());
        return new ResponseEntity<>(cardResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CardResource>> getAllCards(){
        var getAllCardsQuery = new GetAllCardsQuery();
        var cards = cardQueryService.handle(getAllCardsQuery);
        var cardResources= cards.stream().map(CardResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(cardResources);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CardResource> getCardById(@PathVariable Long id){
        var getCardByIdQuery = new GetCardByIdQuery(id);
        var card = cardQueryService.handle(getCardByIdQuery);

        if (card.isEmpty())
            return ResponseEntity.badRequest().build();
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(card.get());
        return ResponseEntity.ok(cardResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResource> updateCard(@PathVariable Long id, @RequestBody UpdateCardResource updateCardResource){
        var updateCardCommand = UpdateCardCommandFromResourceAssembler.toCommandFromResource(id,updateCardResource);
        var updatedCard = cardCommandService.handle(updateCardCommand);

        if(updatedCard.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        var cardResource = CardResourceFromEntityAssembler.toResourceFromEntity(updatedCard.get());
        return ResponseEntity.ok(cardResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id){
        var deleteCardCommand = new DeleteCardCommand(id);
        cardCommandService.handle(deleteCardCommand);
        return ResponseEntity.ok("Card with given id successfully deleted ");
    }
}
