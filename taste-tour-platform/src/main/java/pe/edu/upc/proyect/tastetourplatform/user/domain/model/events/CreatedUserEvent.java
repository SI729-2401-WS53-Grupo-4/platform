package pe.edu.upc.proyect.tastetourplatform.user.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CreatedUserEvent extends ApplicationEvent {
    private final Long userId;

    public CreatedUserEvent(Object source, Long userId) {
        super(source);
        this.userId = userId;
    }
}
