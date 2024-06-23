package pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.CreateRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.commands.DeleteRestaurantCommand;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetAllRestaurantsQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetRestaurantByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantCommandService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.services.RestaurantQueryService;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.CreateRestaurantResource;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.resources.RestaurantResource;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.transform.CreateRestaurantCommandFromResourceAssembler;
import pe.edu.upc.proyect.tastetourplatform.restaurant.interfaces.rest.transform.RestaurantResourceFromEntityAssembler;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.commands.DeleteTourCommand;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetToursByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.TourResource;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform.TourResourceFromEntityAssembler;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value="/Api/v1/TasteTour/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name="Restaurant", description = "Restaurant Managment Endpoints")
public class RestaurantController {
    private final RestaurantCommandService restaurantCommandService;

    private final RestaurantQueryService restaurantQueryService;


    public RestaurantController(RestaurantCommandService restaurantCommandService, RestaurantQueryService restaurantQueryService) {
        this.restaurantCommandService = restaurantCommandService;
        this.restaurantQueryService = restaurantQueryService;
    }

    @Operation(summary = "Obtener lista de Restaurantes")
    @GetMapping
    public ResponseEntity<List<RestaurantResource>> getAllRestaurant(){
        var getAllRestaurantsQuery = new GetAllRestaurantsQuery();
        var restaurants = restaurantQueryService.handle(getAllRestaurantsQuery);
        var restaurantResources= restaurants.stream().map(RestaurantResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(restaurantResources);
    }
    @Operation(summary = "Obtener lista de Restaurantes por Id")
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResource> getRestaurantById(@PathVariable Long id){
        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(id);
        var restaurant = restaurantQueryService.handle(getRestaurantByIdQuery);

        if (restaurant.isEmpty())
            return ResponseEntity.badRequest().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }

    @Operation(summary = "Crear un restaurante")
    @PostMapping("/create")
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
    @Operation(summary = "Eliminar un restaurante por Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        var deleteRestaurantCommand = new DeleteRestaurantCommand(id);
        restaurantCommandService.handle(deleteRestaurantCommand);
        return ResponseEntity.ok("Restaurant with given id successfully deleted ");
    }

}
