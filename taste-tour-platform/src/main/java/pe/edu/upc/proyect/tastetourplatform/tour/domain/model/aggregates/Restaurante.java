package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table (name= "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ubicacion;

    private Date horario;

    public Restaurante(Long id, String nombre, String ubicacion, Date horario) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.horario = horario;
    }
    public Restaurante() {
    }
}
