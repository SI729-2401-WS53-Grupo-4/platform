package pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class SuscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public abstract void metodoPago();

    public void save(SuscriptionPlan suscriptionPlan) {
    }
}
