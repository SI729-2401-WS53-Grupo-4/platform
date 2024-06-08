package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands.CreateUserCommand;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource){
        return new CreateUserCommand(resource.firstName(),resource.lastName(),resource.password(),resource.location(),resource.birthdate(),resource.email(),resource.phone());
    }
}
