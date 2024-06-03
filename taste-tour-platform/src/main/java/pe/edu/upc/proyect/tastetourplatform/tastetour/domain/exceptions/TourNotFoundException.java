package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.exceptions;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(Long along){
        super("Tour with id" + along + "not found");
    }
}
