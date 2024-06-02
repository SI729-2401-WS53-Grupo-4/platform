package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Entity
@Getter
@Setter
@Table(name = "Reserva")
public class Reserva extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTour;

    private String duration;


}