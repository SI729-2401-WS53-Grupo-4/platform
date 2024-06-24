package pe.edu.upc.proyect.tastetourplatform.user.application.internal.outboundservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.proyect.tastetourplatform.iam.interfaces.acl.IamContextFacade;

import java.util.List;

@Service
public class ExternalIamService {
    private final IamContextFacade iamContextFacade;


    public ExternalIamService(IamContextFacade iamContextFacade) {
        this.iamContextFacade = iamContextFacade;
    }

    public Long fetchUserIdByUsername(String username){
        var userId = iamContextFacade.fetchUserIdByUsername(username);

        return userId;
    }

    public Long createUser(String username, String password, List<String> roleNames){
        var userId = iamContextFacade.createUser(username,password,roleNames);
        return userId;
    }


}
