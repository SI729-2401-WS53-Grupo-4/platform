package pe.edu.upc.proyect.tastetourplatform.suscription.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.entities.SuscriptionPlan;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.queries.GetSuscriptionsByIdQuery;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.services.SuscriptionPlanQueryService;
import pe.edu.upc.proyect.tastetourplatform.suscription.infrastructure.persistence.jpa.repositories.SuscriptionPlanRepository;

import java.util.Optional;

@Service
public class SuscriptionPlanQueryServiceImpl implements SuscriptionPlanQueryService {
    private final SuscriptionPlanRepository suscriptionPlanRepository;
    public SuscriptionPlanQueryServiceImpl(SuscriptionPlanRepository suscriptionPlanRepository) {
        this.suscriptionPlanRepository = suscriptionPlanRepository;
    }

    @Override
    public Optional<SuscriptionPlan> handle(GetSuscriptionsByIdQuery query) {
        return Optional.empty();
    }
}
