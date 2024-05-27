package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.ProfileId;

import java.util.List;

@Entity
public class Owner extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private ProfileId profileId;

    @OneToOne(mappedBy = "owner",cascade = CascadeType.ALL)
    private Restaurant restaurant;
}
