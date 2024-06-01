package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.ProfileId;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.UserRecordId;

import java.util.List;

@Entity
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;
    private String location;
    private String birthdate;
    private String email;
    private String phone;

    @Getter
    @Embedded
    @Column(name="user_id")
    private final UserRecordId userRecordId;
    @Embedded
    private ProfileId profileId;

    @OneToOne(mappedBy = "user",cascade =CascadeType.ALL)
    private DebitCard debitCard;

    @OneToOne(mappedBy = "user",cascade =CascadeType.ALL)
    private Review review;

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
    public String getRecordUserId(){
        return this.userRecordId.userRecordId();
    }
    public Long getProfileId(){
        return this.profileId.profileId();
    }
}