package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.ProfileId;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.UserRecordId;

@Entity
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    @Column(name="user_id")
    private final UserRecordId userRecordId;
    @Embedded
    private ProfileId profileId;

    public User(){
        this.userRecordId = new UserRecordId();
    }
    public User(Long profileId){
        this();
        this.profileId = new ProfileId(profileId);
    }
    public User(ProfileId profileId){
        this();
        this.profileId =profileId;
    }
}
