package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record OwnerRecordId(String ownerRecordId) {
    public OwnerRecordId(){
        this(UUID.randomUUID().toString());
    }
    public OwnerRecordId{
        if(ownerRecordId == null || ownerRecordId.isBlank()){
            throw new IllegalArgumentException("Owner record profileId cannot be null or blank");
        }
    }
}
