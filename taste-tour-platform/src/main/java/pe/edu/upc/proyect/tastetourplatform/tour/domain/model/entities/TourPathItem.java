package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Tour;

@Getter
@Entity
public class TourPathItem extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "item_id")
    @NotNull
    private Tour tour;
    @NotNull
    private Long tourId;

    @ManyToOne
    @JoinColumn(name = "next_tour_id")
    private TourPathItem nextTour;
    public TourPathItem(Tour tour, Long tourId, TourPathItem nextTour){
        this.tour = tour;
        this.tourId = tourId;
        this.nextTour = nextTour;
    }
    public TourPathItem(){
        this.tourId = 0L;
        this.nextTour = null;
    }
}
