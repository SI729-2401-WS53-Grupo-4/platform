package pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="premium")
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double descuento;
    private Boolean tourAdicional;
    private Boolean permisoClases;

}
