package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Restaurante;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.*;

@Entity
@Getter
@Setter
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleTour;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "instructor_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "instructor_last_name")),
    })
    private Instructor instructor;

    @NotNull
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

    private Long restauranteId;

    public Tour() {}

    public Tour updatedInformation(String titleTour, Instructor instructor, String description, Rating rating, Capacity capacity, Duration duration, String date, Price price,Long restauranteId){
        this.titleTour = titleTour;
        this.instructor = instructor;
        this.description = description;
        this.rating = rating;
        this.capacity = capacity;
        this.duration = duration;
        this.date = date;
        this.price = price;
        this.restauranteId = restauranteId;
        return this;
    }

    public Tour(String titleTour, Instructor instructor, String description, Rating rating, Capacity capacity, Duration duration, String date, Price price,Long restauranteId) {
        this.titleTour = titleTour;
        this.instructor = instructor;
        this.description = description;
        this.rating = rating;
        this.capacity = capacity;
        this.duration = duration;
        this.date = date;
        this.price = price;
        this.restauranteId = restauranteId;
    }
}
