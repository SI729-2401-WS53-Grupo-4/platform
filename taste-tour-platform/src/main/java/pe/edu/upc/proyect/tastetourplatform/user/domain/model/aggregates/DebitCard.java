package pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;

@Entity
@Getter
@Setter
@Table(name = "DebitCard")
public class DebitCard extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numCard;

    private Long cvv;

    private String date;

    private String name;


    public DebitCard updatedInformation(Long numCard, Long cvv, String date, String name){
        this.numCard = numCard;
        this.cvv = cvv;
        this.date = date;
        this.name = name;
        return this;
    }

    public DebitCard(Long numCard, Long cvv, String date, String name) {
        this.numCard = numCard;
        this.cvv = cvv;
        this.date = date;
        this.name = name;
    }

}
