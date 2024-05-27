package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Getter
@Entity
public class Restaurant extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String time;
}
