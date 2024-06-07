package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Comment(String value) {
    public Comment {
        if (value == null) {
            throw new IllegalArgumentException("Comment cannot be null");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("Comment cannot be empty");
        }
    }
}
