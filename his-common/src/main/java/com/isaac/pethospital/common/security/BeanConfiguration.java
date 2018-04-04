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

                ApplicationUser applicationUser2=new ApplicationUser();
                applicationUser2.setUsername("linghuchong");
                applicationUser2.setPassword(bCryptPasswordEncoder.encode("linghuchong_1"));
                applicationUserRepository.save(applicationUser2);

                ApplicationUser applicationUser3=new ApplicationUser();
                applicationUser3.setUsername("yuelingshan");
                applicationUser3.setPassword(bCryptPasswordEncoder.encode("yuelingshan_1"));
                applicationUserRepository.save(applicationUser3);

                ApplicationUser applicationUser4=new ApplicationUser();
                applicationUser4.setUsername("doctor1");
                applicationUser4.setPassword(bCryptPasswordEncoder.encode("doctor1"));
                applicationUserRepository.save(applicationUser4);

                ApplicationUser applicationUser5=new ApplicationUser();
                applicationUser5.setUsername("guojing");
                applicationUser5.setPassword(bCryptPasswordEncoder.encode("guojing_1"));
                applicationUserRepository.save(applicationUser5);

            }
        };
    }
}
