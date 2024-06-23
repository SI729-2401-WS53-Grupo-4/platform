package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.CardResource;

public class CardResourceFromEntityAssembler {
    public static CardResource toResourceFromEntity(DebitCard entity){
        return new CardResource(entity.getId(), entity.getNumCard(), entity.getCvv(), entity.getDate(),entity.getName());
    }
}
