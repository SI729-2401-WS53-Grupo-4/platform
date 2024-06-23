package pe.edu.upc.proyect.tastetourplatform.user.domain.exceptions;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(Long along){
        super("Review with id " + along + " not found");
    }
}
