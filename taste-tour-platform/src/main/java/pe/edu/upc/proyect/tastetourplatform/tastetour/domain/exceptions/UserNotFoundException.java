package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long along){
        super("User with id " + along + " not found");
    }
}
