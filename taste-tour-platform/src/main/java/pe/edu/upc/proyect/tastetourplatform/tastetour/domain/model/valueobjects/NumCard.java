package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record NumCard(Integer value) {
    public NumCard {
        if (value == null) {
            throw new IllegalArgumentException("NumCard cannot be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("NumCard cannot be negative");
        }
    }
}
