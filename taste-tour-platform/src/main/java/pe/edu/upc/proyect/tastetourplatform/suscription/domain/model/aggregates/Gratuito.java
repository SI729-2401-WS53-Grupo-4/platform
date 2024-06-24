package pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name= "gratuito")
public class Gratuito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean limiteTour;
    private Boolean permisoClases;

    @Override
    public void metodoPago() {
    }
}