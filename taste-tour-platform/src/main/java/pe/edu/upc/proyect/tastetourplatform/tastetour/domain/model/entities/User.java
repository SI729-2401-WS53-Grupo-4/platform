package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.*;

@Entity
@Getter
@Setter
@Table(name="User")
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_firstName"))
    private FirstName firstName;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_lastName"))
    private LastName lastName;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "user_password"))
    private Password password;

    private String location;

    private String birthdate;

    private String email;

    private String phone;

    public User(FirstName firstName, LastName lastName, Password password, String location, String birthdate, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
    }

}
