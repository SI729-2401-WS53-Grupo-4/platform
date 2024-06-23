package pe.edu.upc.proyect.tastetourplatform.user.domain.services;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.Review;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    List<Review> handle(GetAllReviewsQuery query);
    Optional<Review> handle(GetReviewByIdQuery query);
}
