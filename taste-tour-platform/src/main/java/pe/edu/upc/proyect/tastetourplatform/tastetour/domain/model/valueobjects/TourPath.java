package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TourPath {
    @OneToMany(mappedBy = "tour",cascade = CascadeType.ALL)
    private List<TourPathItem> tourPathItems;
    public TourPath(){
        this.tourPathItems = new ArrayList<>();
    }
}
