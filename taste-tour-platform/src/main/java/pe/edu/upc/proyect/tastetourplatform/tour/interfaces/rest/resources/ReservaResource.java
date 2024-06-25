package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.ImageTour;

public record ReservaResource (String titleTour, ImageTour imageTour, Long duration, Long minPrice) {
}
