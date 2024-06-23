package pe.edu.upc.proyect.tastetourplatform.user.domain.services;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.*;

public interface ReviewCommandService {
    Long handle(CreateReviewCommand command);
    void handle(DeleteReviewCommand command);
}
