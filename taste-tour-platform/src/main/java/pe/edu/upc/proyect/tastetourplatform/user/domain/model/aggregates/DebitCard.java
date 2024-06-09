package pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

@Entity
@Getter
@Setter
@Table(name = "DebitCard")
public class DebitCard extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "card_num"))
    private NumCard numCard;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "card_cvv"))
    private Cvv cvv;

    private String date;

    private String name;
}
