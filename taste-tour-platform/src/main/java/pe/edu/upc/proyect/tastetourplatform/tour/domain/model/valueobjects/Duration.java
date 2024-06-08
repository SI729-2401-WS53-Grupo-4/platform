package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Duration(String value) {
    public Duration {
        if (value == null) {
            throw new IllegalArgumentException("Duration cannot be null");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Duration cannot be empty");
        }
    }
}