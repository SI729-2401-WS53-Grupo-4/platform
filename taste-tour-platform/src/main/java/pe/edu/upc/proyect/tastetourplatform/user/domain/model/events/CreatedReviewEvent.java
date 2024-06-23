package pe.edu.upc.proyect.tastetourplatform.user.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedReviewEvent extends ApplicationEvent {
    private final Long reviewId;

    public CreatedReviewEvent(Object source, Long reviewId) {
        super(source);
        this.reviewId = reviewId;
    }
}
