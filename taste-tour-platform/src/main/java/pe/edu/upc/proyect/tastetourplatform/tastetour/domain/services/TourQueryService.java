package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services;

import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetToursByIdQuery;

import java.util.List;
import java.util.Optional;


public interface TourQueryService {
   List<Tour> handle(GetAllToursQuery query);
   Optional<Tour> handle(GetToursByIdQuery query);

}
