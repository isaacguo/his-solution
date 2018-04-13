package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.dtos.AuthorizationOperationRequest;
import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.services.AuthorizationService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/{id}")
    public boolean deleteAuthorization(@PathVariable("id") Long id)
    {
        return this.authorizationService.deleteById(id);
    }

    @PostMapping("create")
    public boolean createAuthorizationAssignment(@RequestBody AuthorizationOperationRequest request) {
        //setUserAccount(request);
        return this.authorizationService.createAuthorization(request);
    }
    @PutMapping("update")
    public boolean updateAuthorization(@RequestBody AuthorizationOperationRequest request)
    {
        return this.authorizationService.updateAuthorization(request);
    }
}
