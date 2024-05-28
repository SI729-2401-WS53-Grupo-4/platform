package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.aggregates;

import jakarta.persistence.*;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;


@Entity
public class Restaurant extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String time;
    @OneToOne
    @JoinColumn(name="owner_id", unique = true)
    private Owner owner;
}
