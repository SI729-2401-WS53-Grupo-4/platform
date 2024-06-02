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
    private Instructor instructor;

    private String description;

    @Embedded
    private Rating rating;

    @Embedded
    private Capacity capacity;

    @Embedded
    private Duration duration;

    private String date;

    @Embedded
    private Price price;

    public Tour(){};
    public Tour(String titleTour, Instructor instructor, String description, Rating rating, Capacity capacity, Duration duration, String date, Price price){
        this.titleTour = titleTour;
        this.instructor = instructor;
        this.description = description;
        this.rating = rating;
        this.capacity = capacity;
        this.duration = duration;
        this.date = date;
        this.price = price;
    }

}
