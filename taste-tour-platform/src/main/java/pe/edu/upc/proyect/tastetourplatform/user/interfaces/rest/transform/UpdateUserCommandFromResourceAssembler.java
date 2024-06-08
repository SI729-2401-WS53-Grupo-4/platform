package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.UpdateUserCommand;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.UpdateUserResource;

public class UpdateUserCommandFromResourceAssembler {
    public static UpdateUserCommand toCommandFromResource(Long id, UpdateUserResource resource){
        return new UpdateUserCommand(id,resource.firstName(),resource.lastName(),resource.password(),resource.location(),resource.birthdate(),resource.email(),resource.phone());
    }
}
