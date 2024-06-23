package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects.Image;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant extends AuditableAbstractAggregateRoot<Restaurant> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Embedded
    private Image image;

    private String bookingLink;

    public Restaurant(CreateRestaurantCommand command ) {
        this.name = command.name();
        this.description = command.description();
        this.image = command.image();
        this.bookingLink = command.bookingLink();
    }
    public Restaurant(String name, String description, Image image,String bookingLink){
        this.name = name;
        this.description = description;
        this.image= image;
        this.bookingLink = bookingLink;
    }

    public Restaurant() {

    }
}
