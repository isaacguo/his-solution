package com.isaac.pethospital.common.jms;

import com.isaac.pethospital.common.dtos.JmsEmployeeOperationRequest;
import com.isaac.pethospital.common.services.AuthorizationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsEmployeeUserAccountOperationTopicListener {

    private final AuthorizationService authorizationService;

    public JmsEmployeeUserAccountOperationTopicListener(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @JmsListener(destination = "${jms.employee-useraccount-operation-topic}")
    public void processMessage(JmsEmployeeOperationRequest request) throws Exception {
        this.authorizationService.onUserChanged(request);
    }
}
