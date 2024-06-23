package pe.edu.upc.proyect.tastetourplatform.user.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.Review;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetAllReviewsQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetReviewByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.ReviewQueryService;
import pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;

    public ReviewQueryServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> handle(GetAllReviewsQuery query){
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> handle(GetReviewByIdQuery query){
        return reviewRepository.findById(query.reviewId());
    }
}
