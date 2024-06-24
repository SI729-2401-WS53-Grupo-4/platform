package pe.edu.upc.proyect.tastetourplatform.suscription.domain.services;

import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.entities.SuscriptionPlan;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.queries.GetSuscriptionsByIdQuery;

import java.util.Optional;

public interface SuscriptionPlanQueryService {
    Optional<SuscriptionPlan> handle(GetSuscriptionsByIdQuery query);
}
