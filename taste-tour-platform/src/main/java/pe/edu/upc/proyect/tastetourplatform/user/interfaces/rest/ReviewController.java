package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.DeleteReviewCommand;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetAllReviewsQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.queries.GetReviewByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.ReviewCommandService;
import pe.edu.upc.proyect.tastetourplatform.user.domain.services.ReviewQueryService;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.CreateReviewResource;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.ReviewResource;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform.CreateReviewCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform.ReviewResourceFromEntityAssembler;

import java.util.List;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/review", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Review", description = "Review Managment Endpoints")
public class ReviewController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    public ReviewController(ReviewCommandService reviewCommandService, ReviewQueryService reviewQueryService){
        this.reviewCommandService = reviewCommandService;
        this.reviewQueryService = reviewQueryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewResource> createReview(@RequestBody CreateReviewResource createReviewResource){
        var createReviewCommand = CreateReviewCommandFromResourceAssembler.toCommandFromResource(createReviewResource);
        var reviewId = reviewCommandService.handle(createReviewCommand);

        if (reviewId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getReviewByIdQuery = new GetReviewByIdQuery(reviewId);
        var review = reviewQueryService.handle(getReviewByIdQuery);

        if (review.isEmpty())
            return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(review.get());
        return new ResponseEntity<>(reviewResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReviewResource>> getAllReviews(){
        var getAllReviewsQuery = new GetAllReviewsQuery();
        var reviews = reviewQueryService.handle(getAllReviewsQuery);
        var reviewResources= reviews.stream().map(ReviewResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(reviewResources);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReviewResource> getReviewById(@PathVariable Long id){
        var getReviewByIdQuery = new GetReviewByIdQuery(id);
        var review = reviewQueryService.handle(getReviewByIdQuery);

        if (review.isEmpty())
            return ResponseEntity.badRequest().build();
        var reviewResource = ReviewResourceFromEntityAssembler.toResourceFromEntity(review.get());
        return ResponseEntity.ok(reviewResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id){
        var deleteReviewCommand = new DeleteReviewCommand(id);
        reviewCommandService.handle(deleteReviewCommand);
        return ResponseEntity.ok("Review with given id successfully deleted ");
    }

}
