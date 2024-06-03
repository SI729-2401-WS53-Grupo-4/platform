package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.services;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates.Tour;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.queries.GetToursByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tastetour.insfractructure.persistence.jpa.repositories.TourRepository;

import java.util.List;
import java.util.Optional;


public interface TourQueryService {
   List<Tour> handle(GetAllToursQuery query);
   Optional<Tour> handle(GetToursByIdQuery query);

}
