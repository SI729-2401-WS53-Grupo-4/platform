package pe.edu.upc.proyect.tastetourplatform.suscription.application.internal.commandservices;

import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.commands.AddSuscriptionPlanCommand;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.commands.DeleteSuscriptionPlanCommand;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.model.entities.SuscriptionPlan;
import pe.edu.upc.proyect.tastetourplatform.suscription.domain.services.SuscriptionPlanCommandService;
import pe.edu.upc.proyect.tastetourplatform.suscription.infrastructure.persistence.jpa.repositories.SuscriptionPlanRepository;

public class SuscriptionPlanCommandServiceImpl implements SuscriptionPlanCommandService {
    private final SuscriptionPlanRepository suscriptionPlanRepository;


    public SuscriptionPlanCommandServiceImpl(SuscriptionPlanRepository suscriptionPlanRepository) {
        this.suscriptionPlanRepository = suscriptionPlanRepository;
    }


    @Override
    public Long handle(AddSuscriptionPlanCommand command) {
        SuscriptionPlan suscriptionPlan =new SuscriptionPlan();
    }

    @Override
    public void handle(DeleteSuscriptionPlanCommand command) {
        suscriptionPlanRepository.deleteById(command.suscriptionPlanId());

    }
}
