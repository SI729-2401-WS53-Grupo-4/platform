package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record FirstName(String value) {
    public FirstName {
        if (value == null) {
            throw new IllegalArgumentException("FirstName cannot be null");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("FirstName cannot be empty");
        }
    }
}
