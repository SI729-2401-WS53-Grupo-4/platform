package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public record Price(Integer value) {
    public Price {
        if (value == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }
}
