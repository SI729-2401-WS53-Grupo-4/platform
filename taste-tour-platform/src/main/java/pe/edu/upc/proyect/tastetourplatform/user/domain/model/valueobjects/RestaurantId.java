package pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects;

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
