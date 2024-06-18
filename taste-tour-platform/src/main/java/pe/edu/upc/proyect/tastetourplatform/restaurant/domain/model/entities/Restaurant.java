package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String location;

    @NotEmpty
    @Column(nullable = false)
    private String time;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    public Restaurant(CreateRestaurantCommand command ) {
        this.name = command.name();
        this.location = command.location();
        this.time = command.time();
        this.description = command.description();
    }
    public Restaurant(){}
}
