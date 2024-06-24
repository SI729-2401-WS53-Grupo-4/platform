package pe.edu.upc.proyect.tastetourplatform.suscription.domain.services;

import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.commands.AddSuscriptionPlanCommand;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.commands.DeleteSuscriptionPlanCommand;

public interface SuscriptionPlanCommandService {
    Long handle(AddSuscriptionPlanCommand command);
    void handle(DeleteSuscriptionPlanCommand command);
}
