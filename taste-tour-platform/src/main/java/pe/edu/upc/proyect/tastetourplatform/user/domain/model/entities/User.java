package pe.edu.upc.proyect.tastetourplatform.user.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.aggregates.Reserva;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="User")
public class User extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long password;

    private String location;

    private Date birthdate;

    private String email;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "debit_card_id", referencedColumnName = "id")
    private DebitCard debitCard;

    public User() {
    }

    public User updatedInformation(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.debitCard = debitCard;
        return this;
    }

    public User(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone,  DebitCard debitCard){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.location = location;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.debitCard = debitCard;
    }

}
