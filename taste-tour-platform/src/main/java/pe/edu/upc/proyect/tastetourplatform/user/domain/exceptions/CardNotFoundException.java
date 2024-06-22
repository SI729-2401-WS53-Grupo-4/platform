package pe.edu.upc.proyect.tastetourplatform.user.domain.exceptions;

public class CardNotFoundException extends RuntimeException{
    public CardNotFoundException(Long along){
        super("Card with id " + along + " not found");
    }
}
