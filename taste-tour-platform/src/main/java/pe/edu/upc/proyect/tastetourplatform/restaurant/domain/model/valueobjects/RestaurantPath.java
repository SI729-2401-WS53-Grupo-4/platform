package pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.RestaurantPathItem;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class RestaurantPath {
    private List<RestaurantPathItem> restaurantPathItems;

public RestaurantPath(){
    this.restaurantPathItems= new ArrayList<>();
}

public void addRestaurant(Long restaurantId, RestaurantPathItem nextItem){
    System.out.println("Adding item to restaurant path");
    RestaurantPathItem restaurantPathItem = new RestaurantPathItem();
    System.out.println("restaurant id" + RestaurantPathItem.getRestaurantId());

}
}
