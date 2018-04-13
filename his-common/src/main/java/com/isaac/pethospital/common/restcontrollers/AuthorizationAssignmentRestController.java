package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;
import com.isaac.pethospital.common.repositories.AuthorizationAssignmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authorization-assignments")
public class AuthorizationAssignmentRestController {

    private final AuthorizationAssignmentRepository authorizationAssignmentRepository;

    public AuthorizationAssignmentRestController(AuthorizationAssignmentRepository authorizationAssignmentRepository) {
        this.authorizationAssignmentRepository = authorizationAssignmentRepository;
    }

    @GetMapping
    public List<AuthorizationAssignmentEntity> getAll()
    {
        return this.authorizationAssignmentRepository.findAll();
    }
}
