package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RestaurantId(Long restaurantId) {
    public RestaurantId{
        if(restaurantId < 0){
            throw new IllegalArgumentException("Restaurant restaurantId cannot be negative");
        }
    }
    public RestaurantId(){
        this(0L);
    }
}
