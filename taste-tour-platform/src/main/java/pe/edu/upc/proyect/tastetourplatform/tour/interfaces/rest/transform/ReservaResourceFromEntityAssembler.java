package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.ReservaResource;

public class ReservaResourceFromEntityAssembler {
    public static ReservaResource toResourceFromEntity(Reserva entity){
        Long tourId = (entity.getTour_id() != null) ? entity.getTour_id().getId() : null;
        return new ReservaResource(entity.getId(), entity.getTitle(), entity.getImage(), entity.getDuration(), entity.getPrice(),tourId);
    }
}
