package pe.edu.upc.proyect.tastetourplatform.tour.domain.exceptions;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(Long along){
        super("Tour with id " + along + " not found");
    }
}
