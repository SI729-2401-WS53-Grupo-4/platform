package pe.edu.upc.proyect.tastetourplatform.tour.interfaces.rest.resources;

import pe.edu.upc.proyect.tastetourplatform.tour.domain.model.valueobjects.Price;

public record ReservaResource(Long id, String title, String image, Integer duration, Price price, Long tourId) {
}
