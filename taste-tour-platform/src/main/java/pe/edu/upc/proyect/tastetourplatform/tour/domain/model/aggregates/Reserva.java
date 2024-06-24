package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
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

    private String title;

    private String image;

    private Integer duration;

    @Embedded
    private Price price;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour_id;

    public Reserva(String title,String image, Integer duration, Price price, Tour tour_id){
        this.title = title;
        this.image = image;
        this.duration = duration;
        this.price = price;
        this.tour_id = tour_id;
    }

    public Reserva() {

    }
}
