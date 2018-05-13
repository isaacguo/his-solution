package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.FactoryResetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("factory-reset")
public class FactoryResetRestController {


    private final FactoryResetService factoryResetService;
    private final AuthHelper authHelper;

    public FactoryResetRestController(FactoryResetService factoryResetService, AuthHelper authHelper) {
        this.factoryResetService = factoryResetService;
        this.authHelper = authHelper;
    }

    @PostMapping()
    public void reset() {
        String requester = this.authHelper.getUserAccount();
        if (requester.equals("admin"))
            this.factoryResetService.reset();
    }


    @PostMapping("/fillDemoData")
    public void fillDemoData() {
        String requester = this.authHelper.getUserAccount();
        if (requester.equals("admin"))
            this.factoryResetService.insertData();
    }

}
