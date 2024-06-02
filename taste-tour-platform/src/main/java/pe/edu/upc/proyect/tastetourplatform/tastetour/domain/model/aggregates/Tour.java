package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Entity
@Getter
@Setter
@Table(name = "Tour")
public class Tour extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleTour;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    private String description;

    private String rating;

    private String max;

    private String duration;

    private String date;

    private String price;

}
