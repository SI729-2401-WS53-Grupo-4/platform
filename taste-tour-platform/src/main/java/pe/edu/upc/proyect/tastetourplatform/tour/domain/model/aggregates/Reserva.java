package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.ImageTour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.Price;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.entities.User;

@Entity
@Getter
@Setter
@Table(name = "Reserva")
public class Reserva extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    // Datos del tour copiados
    private String titleTour;
    @Embedded
    private ImageTour imageTour;

    private Long duration;

    private Long minPrice;

    public Reserva() {

    }
    public Reserva(Tour tour){
        this.tour = tour;
        if (tour != null) {
            this.titleTour = tour.getTitleTour();
            this.imageTour = tour.getImageTour();
            this.duration = tour.getDuration();
            this.minPrice = tour.getMinPrice();
        }

    }


}
