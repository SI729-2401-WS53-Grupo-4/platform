package pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Password(String value) {
    public Password {
        if (value == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }
}
