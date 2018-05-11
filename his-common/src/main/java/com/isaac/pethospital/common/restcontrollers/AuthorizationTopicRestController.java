package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.entities.AuthorizationTopicEntity;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authorization-topics")
public class AuthorizationTopicRestController {


    private final AuthorizationTopicService authorizationTopicService;

    public AuthorizationTopicRestController(AuthorizationTopicService authorizationTopicService) {
        this.authorizationTopicService = authorizationTopicService;
    }

    @GetMapping
    public List<AuthorizationTopicEntity> getTopics()
    {
        return this.authorizationTopicService.findAll();
    }
}
