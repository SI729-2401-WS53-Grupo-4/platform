package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public record Price(Integer amount) {

    public Price {
        if (amount < 0) {
            throw new IllegalArgumentException("Price amount must be positive");
        }
    }

    @Override
    public String toString() {
        return "Price: " +
                "amount=" + amount + '\'';
    }
}
