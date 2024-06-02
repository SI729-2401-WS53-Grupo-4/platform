package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Capacity(int value) {
    public Capacity {
        if (value <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
    }
}
