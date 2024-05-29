package pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record UserRecordId(String userRecordId) {
    public  UserRecordId(){
        this(UUID.randomUUID().toString());
    }
    public UserRecordId{
        if (userRecordId == null || userRecordId.isBlank()){
            throw new IllegalArgumentException("User student record profileId cannot be null or blank");
        }
    }
}
