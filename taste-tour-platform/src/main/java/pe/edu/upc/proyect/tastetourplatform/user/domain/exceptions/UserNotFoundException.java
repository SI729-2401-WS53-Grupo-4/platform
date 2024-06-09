package pe.edu.upc.proyect.tastetourplatform.user.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long along){
        super("User with id " + along + " not found");
    }
}
