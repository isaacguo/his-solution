package com.isaac.pethospital.common.security;

import com.isaac.pethospital.common.entities.ApplicationUser;
import com.isaac.pethospital.common.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
class BeanConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationUserRepository applicationUserRepository) {

        return new CommandLineRunner() {

            @Autowired
            BCryptPasswordEncoder bCryptPasswordEncoder;

            @Override
            public void run(String... strings) throws Exception {

                ApplicationUser applicationUser = new ApplicationUser();
                applicationUser.setUsername("admin");
                applicationUser.setPassword(bCryptPasswordEncoder.encode("admin"));
                applicationUserRepository.save(applicationUser);

            }
        };
    }
}
