package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.*;

@Entity
@Getter
@Setter
@Table(name = "Tour")
public class Tour extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleTour;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "instructor_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "instructor_last_name")),
            @AttributeOverride(name = "rating", column = @Column(name = "instructor_rating"))
    })
    private Instructor instructor;

    private String description;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "tour_rating"))
    private Rating rating;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "tour_capacity"))
    private Capacity capacity;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "tour_duration"))
    private Duration duration;

    private String date;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "tour_price"))
    private Price price;

    public Tour() {}

    public Tour(String titleTour, Instructor instructor, String description, Rating rating, Capacity capacity, Duration duration, String date, Price price) {
        this.titleTour = titleTour;
        this.instructor = instructor;
        this.description = description;
        this.rating = rating;
        this.capacity = capacity;
        this.duration = duration;
        this.date = date;
        this.price = price;
    }

    public Tour(String titleTour, String description, Instructor instructor, Rating rating, Capacity capacity, Duration duration, String date, Price price) {
    }
}
