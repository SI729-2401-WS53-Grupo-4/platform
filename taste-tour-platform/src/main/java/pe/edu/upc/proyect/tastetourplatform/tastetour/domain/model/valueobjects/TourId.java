package pe.edu.upc.proyect.tastetourplatform.tastetour.domain.model.valueobjects;

public record TourId(Long tourId) {
    public TourId{
        if(tourId < 0){
            throw new IllegalArgumentException("Tour tourId cannot be negative");
        }
    }
    public TourId(){
        this(0L);
    }
}
