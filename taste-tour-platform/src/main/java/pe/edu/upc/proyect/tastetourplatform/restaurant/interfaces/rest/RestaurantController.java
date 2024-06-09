package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantCommandService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantQueryService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.CreateRestaurantResource;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.RestaurantResource;

import java.awt.*;

@RestController
@RequestMapping(value="/api/v1/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Restaurant", description = "Restaurant Managment Endpoints")
public class RestaurantController {
    private final RestaurantCommandService restaurantCommandService;

    private final RestaurantQueryService restaurantQueryService;

    public RestaurantController(RestaurantCommandService restaurantCommandService, RestaurantQueryService restaurantQueryService, RestaurantCommandService restaurantCommandService1, RestaurantQueryService restaurantQueryService1){

        this.restaurantCommandService = restaurantCommandService;
        this.restaurantQueryService = restaurantQueryService;
    }

    @PostMapping
    public ResponseEntity<RestaurantResource> createRestaurant(@RequestBody CreateRestaurantResource resource){
        var createRestaurantCommand = CreateRestaurantCommandFromResourceAssembler.toCommandFromResource(resource);
        var restaurantId = restaurantCommandService.handle(createRestaurantCommand);

        if(restaurantId==0L){
            return ResponseEntity.badRequest().build();
        }

        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(restaurantId);
        var restaurant = restaurantQueryService.handle(getRestaurantByIdQuery);

        if(restaurant.isEmpty())
            return ResponseEntity.badRequest().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return new ResponseEntity<>(restaurantResource, HttpStatus.CREATED);

    }

}
