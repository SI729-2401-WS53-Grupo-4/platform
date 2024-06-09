package pe.edu.upc.proyect.tastetourplatform.tour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.entities.Restaurant;
import pe.edu.upc.proyect.tastetourplatform.restaurant.domain.model.queries.GetAllRestaurantsQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetToursByIdQuery;

import java.util.List;
import java.util.Optional;


public interface TourQueryService {
   List<Tour> handle(GetAllToursQuery query);
   Optional<Tour> handle(GetToursByIdQuery query);

}
