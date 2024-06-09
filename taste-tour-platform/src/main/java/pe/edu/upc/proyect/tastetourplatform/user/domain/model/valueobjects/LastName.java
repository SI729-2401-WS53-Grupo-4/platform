package pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record LastName(String value) {
    public LastName {
        if (value == null) {
            throw new IllegalArgumentException("LastName cannot be null");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("LastName cannot be empty");
        }
    }
}
