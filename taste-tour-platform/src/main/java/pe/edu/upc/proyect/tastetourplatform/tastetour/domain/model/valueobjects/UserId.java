package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record UserId (Long userId) {
    public UserId{
        if(userId < 0){
            throw new IllegalArgumentException("userId cannot be negative");
        }
    }
    public UserId(){
        this(0L);
    }
}
