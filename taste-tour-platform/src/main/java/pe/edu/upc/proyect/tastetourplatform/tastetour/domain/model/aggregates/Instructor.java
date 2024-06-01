package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Entity
@Getter
@Table(name= "Instructor")
public class Instructor extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String rating;
}
