package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;
import pe.edu.upc.proyect.tastetourplatform.shared.domain.model.entities.AuditableModel;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.entities.TourPathItem;
import pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects.TourPath;

@Getter
@Entity
public class Tour extends AuditableModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String titleTour;

   private String instructor;

   private String description;

   private String value;

   private String max;

   private String time;

   private String price;

   @Embedded
   private final TourPath tourPath;

   @ManyToOne
   @JoinColumn(name="user_id")
   private User user;

   @ManyToOne
   @JoinColumn(name = "restaurant_id")
   private Restaurant restaurant;

   public Tour(){
       this.titleTour = Strings.EMPTY;
       this.instructor = Strings.EMPTY;
       this.description = Strings.EMPTY;
       this.value = Strings.EMPTY;
       this.max = Strings.EMPTY;
       this.time = Strings.EMPTY;
       this.price = Strings.EMPTY;
       this.tourPath = new TourPath();
   }

   public Tour(String titleTour, String instructor, String description,String value, String max, String time, String price){
       this();
       this.titleTour = titleTour;
       this.instructor = instructor;
       this.description = description;
       this.value = value;
       this.max = max;
       this.price = price;
   }
}
