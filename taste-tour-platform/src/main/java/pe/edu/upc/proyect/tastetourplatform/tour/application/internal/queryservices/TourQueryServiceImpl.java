package pe.edu.upc.proyect.tastetourplatform.tour.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.entities.Tour;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetAllToursQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.queries.GetToursByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.services.TourQueryService;
import pe.edu.upc.proyect.tastetourplatform.tour.insfractructure.persistence.jpa.repositories.TourRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TourQueryServiceImpl implements TourQueryService {
    private final TourRepository tourRepository;

    public TourQueryServiceImpl(TourRepository tourRepository){
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> handle(GetAllToursQuery query){
        return tourRepository.findAll();
    }

    @Override
    public Optional<Tour> handle(GetToursByIdQuery query){
        return tourRepository.findById(query.tourId());
    }
}
