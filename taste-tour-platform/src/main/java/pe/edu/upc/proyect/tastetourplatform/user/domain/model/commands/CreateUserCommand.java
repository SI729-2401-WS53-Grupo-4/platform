package pe.edu.upc.proyect.tastetourplatform.user.domain.model.commands;

import pe.edu.upc.proyect.tastetourplatform.user.domain.model.aggregates.DebitCard;
import pe.edu.upc.proyect.tastetourplatform.user.domain.model.valueobjects.*;

import java.util.Date;

public record CreateUserCommand(String firstName, String lastName, Long password, String location, Date birthdate, String email, String phone, DebitCard debitCard) {
}
