package pe.edu.upc.proyect.tastetourplatform.Api;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class TourApi {

    @GetMapping
    public String[] tour(){
      String[] tourApi={"nombre","descripción"};
      return tourApi;
    }
}
