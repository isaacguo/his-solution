package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.services.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authorizations")
public class AuthorizationRestController {

    private final AuthorizationService authorizationService;

    public AuthorizationRestController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping
    public List<AuthorizationEntity> getAuthorizations() {
        return this.authorizationService.findAll();
    }
}
