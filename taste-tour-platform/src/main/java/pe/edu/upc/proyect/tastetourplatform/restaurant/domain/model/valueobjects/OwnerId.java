package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record OwnerId(Long profileId) {

    public OwnerId {
        if (profileId < 0) {
            throw new IllegalArgumentException("ProfileId cannot be negative");
        }
    }

    public OwnerId() {
        this(0L);
    }
}