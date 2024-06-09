package pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.transform;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.entities.User;
import pe.edu.upc.proyect.tastetourplatform.user.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        return new UserResource(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getPassword(),entity.getLocation(),entity.getBirthdate(),entity.getEmail(),entity.getPhone());
    }
}
