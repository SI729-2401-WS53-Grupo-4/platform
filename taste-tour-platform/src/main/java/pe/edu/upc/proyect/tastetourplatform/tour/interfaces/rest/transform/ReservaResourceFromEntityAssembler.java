package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources.ReservaResource;

public class ReservaResourceFromEntityAssembler {
    public static  ReservaResource toResourceFromEntity(Reserva entity){
        return new ReservaResource(entity.getTitleTour(), entity.getImageTour(),entity.getDuration(),entity.getMinPrice());
    }

}
