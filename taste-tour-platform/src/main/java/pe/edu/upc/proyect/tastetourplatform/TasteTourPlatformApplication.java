package pe.edu.upc.proyect.tastetourplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TasteTourPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasteTourPlatformApplication.class, args);
	}

}
