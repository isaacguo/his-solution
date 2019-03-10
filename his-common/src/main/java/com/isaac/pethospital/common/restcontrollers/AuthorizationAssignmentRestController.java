package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import com.isaac.pethospital.common.repositories.AuthorizationAssignmentRepository;
import com.isaac.pethospital.common.security.AuthHelper;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authorization-assignments")
public class AuthorizationAssignmentRestController {

    private final AuthorizationAssignmentRepository authorizationAssignmentRepository;
    private final AuthHelper authHelper;

    public AuthorizationAssignmentRestController(AuthorizationAssignmentRepository authorizationAssignmentRepository, AuthHelper authHelper) {
        this.authorizationAssignmentRepository = authorizationAssignmentRepository;
        this.authHelper = authHelper;
    }

    @GetMapping
    public List<AuthorizationAssignmentEntity> getAll() {
        return this.authorizationAssignmentRepository.findAll();
    }


}
