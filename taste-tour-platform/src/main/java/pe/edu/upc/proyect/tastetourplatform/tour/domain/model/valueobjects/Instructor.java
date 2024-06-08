package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Instructor(String firstName, String lastName) {

    public Instructor {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
    }
}