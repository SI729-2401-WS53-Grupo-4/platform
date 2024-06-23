package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.UpdateCardCommand;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.UpdateCardResource;

public class UpdateCardCommandFromResourceAssembler {
    public static UpdateCardCommand toCommandFromResource(Long id, UpdateCardResource resource){
        return new UpdateCardCommand(id,resource.numCard(),resource.cvv(),resource.date(),resource.name());
    }
}
