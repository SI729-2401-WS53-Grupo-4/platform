package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.AddCardCommand;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.AddCardResource;

public class AddCardCommandFromResourceAssembler {
    public static AddCardCommand toCommandFromResource(AddCardResource resource){
        return new AddCardCommand(resource.numCard(),resource.cvv(),resource.date(),resource.name());
    }
}
