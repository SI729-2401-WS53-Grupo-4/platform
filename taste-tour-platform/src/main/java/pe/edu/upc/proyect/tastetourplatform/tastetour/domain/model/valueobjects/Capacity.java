package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Capacity(Integer value) {
    public Capacity {
        if (value == null) {
            throw new IllegalArgumentException("Capacity cannot be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
    }
}
