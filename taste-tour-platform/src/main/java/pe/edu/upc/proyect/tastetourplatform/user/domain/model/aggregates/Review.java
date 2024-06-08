package pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

@Entity
@Getter
@Setter
@Table(name = "Review")
public class Review extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "review_rating"))
    private Rating rating;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "review_comment"))
    private Comment comment;

}
