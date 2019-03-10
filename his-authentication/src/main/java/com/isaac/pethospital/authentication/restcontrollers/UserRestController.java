package com.isaac.pethospital.authentication.restcontrollers;


import com.isaac.pethospital.authentication.dtos.ApplicationUserOperationRequest;
import com.isaac.pethospital.authentication.entities.ApplicationUser;
import com.isaac.pethospital.authentication.repositories.ApplicationUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRestController(ApplicationUserRepository applicationUserRepository,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUserOperationRequest user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        ApplicationUser applicationUser=new ApplicationUser();
        applicationUser.setPassword(user.getPassword());
        applicationUser.setUsername(user.getUsername());
        applicationUserRepository.save(applicationUser);
    }
}
