package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

public record RestaurantId(Long restaurantId) {
    public RestaurantId {
        if(restaurantId < 0){
            throw new IllegalArgumentException("userId cannot be negative");
        }
    }
    public RestaurantId(){
        this(0L);
    }
}
