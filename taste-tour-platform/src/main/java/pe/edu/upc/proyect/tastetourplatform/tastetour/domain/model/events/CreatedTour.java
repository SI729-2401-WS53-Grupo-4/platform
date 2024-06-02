package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.events;

public class CreatedTour {
    private final Long tourId;

    public CreatedTour(Long tourId){
        this.tourId = tourId;
    }

    public Long getTourId(){
        return tourId;
    }
}
