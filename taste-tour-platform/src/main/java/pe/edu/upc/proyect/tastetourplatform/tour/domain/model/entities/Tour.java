package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tour")
public class Tour extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleTour;

    @Embedded
    private ImageTour imageTour;

    private String instructor;

    private Long rating;

    private Long nRatings;

    @Embedded
    private Price minPrice;

    private Long currentPeople;

    private Long maxPeople;

    private String language;

    private Long duration;

    @ElementCollection
    private List<String> itemsIncluded;

    private String date;

    private String description;

    @ElementCollection
    private List<String> times;

    private String hours;

    @ManyToOne
    @JoinColumn(name= "restaurant_id")
    private Restaurant restaurantId;

    public Tour() {}

    public Tour updatedInformation(String titleTour, ImageTour imageTour, String instructor, Long rating, Long nRatings, Price minPrice, Long currentPeople, Long maxPeople, String language, Long duration, List<String> itemsIncluded, String date, String description, List<String> times, String hours, Restaurant restaurantId){
        this.titleTour = titleTour;
        this.imageTour = imageTour;
        this.instructor = instructor;
        this.rating = rating;
        this.nRatings = nRatings;
        this.minPrice = minPrice;
        this.currentPeople = currentPeople;
        this.maxPeople = maxPeople;
        this.language = language;
        this.duration = duration;
        this.itemsIncluded = itemsIncluded;
        this.date = date;
        this.description = description;
        this.times = times;
        this.hours = hours;
        this.restaurantId = restaurantId;
        return this;
    }

    public Tour(String titleTour, ImageTour imageTour, String instructor, Long rating, Long nRatings, Price minPrice, Long currentPeople, Long maxPeople, String language, Long duration, List<String> itemsIncluded, String date, String description, List<String> times, String hours, Restaurant restaurantId) {
        this.titleTour = titleTour;
        this.imageTour = imageTour;
        this.instructor = instructor;
        this.rating = rating;
        this.nRatings = nRatings;
        this.minPrice = minPrice;
        this.currentPeople = currentPeople;
        this.maxPeople = maxPeople;
        this.language = language;
        this.duration = duration;
        this.itemsIncluded = itemsIncluded;
        this.date = date;
        this.description = description;
        this.times = times;
        this.hours = hours;
        this.restaurantId = restaurantId;
    }
}
