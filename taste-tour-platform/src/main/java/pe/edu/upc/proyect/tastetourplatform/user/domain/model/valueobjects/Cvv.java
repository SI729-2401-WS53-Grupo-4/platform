package pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Cvv(Integer value) {
    public Cvv {
        if (value == null) {
            throw new IllegalArgumentException("Cvv cannot be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Cvv cannot be negative");
        }
    }
}
