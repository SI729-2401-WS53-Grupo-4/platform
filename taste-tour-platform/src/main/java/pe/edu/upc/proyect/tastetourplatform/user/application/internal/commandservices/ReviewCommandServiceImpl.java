package pe.edu.upc.proyect.tastetourplatform.user.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.Review;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.CreateReviewCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.DeleteReviewCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.ReviewCommandService;
import pe.edu.upc.proyect.tastetourplatform.user.insfractructure.persistence.jpa.repositories.ReviewRepository;

@Service
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;

    public ReviewCommandServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Long handle(CreateReviewCommand command){
        Review review = new Review(
                command.rating(),
                command.comment()
        );
        reviewRepository.save(review);
        return review.getId();
    }

    @Override
    public void handle(DeleteReviewCommand command){
        reviewRepository.deleteById(command.reviewId());
        System.out.println("Review Delete");
    }
}
