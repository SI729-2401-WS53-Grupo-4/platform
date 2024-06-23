package pe.edu.upc.proyect.tastetourplatform.user.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedCardEvent extends ApplicationEvent {
    private final Long cardId;

    public CreatedCardEvent(Object source, Long cardId) {
        super(source);
        this.cardId = cardId;
    }
}
