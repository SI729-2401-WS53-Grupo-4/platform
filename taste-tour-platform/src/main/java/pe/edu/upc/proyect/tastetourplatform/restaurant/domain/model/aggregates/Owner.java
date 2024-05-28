package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects.OwnerId;

@Entity
public class Owner extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private OwnerId ownerId;

    @OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
    private Restaurant restaurant;
}
