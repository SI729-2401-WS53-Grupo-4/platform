package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Rating(double value) {
    public Rating {
        if (value < 0 || value > 5) {
            throw new IllegalArgumentException("Rating must be between 0 and 5");
        }
    }
}