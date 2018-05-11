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

                generateTempUsernameAndPassword("linzhennan");
                generateTempUsernameAndPassword("yucanghai");
                generateTempUsernameAndPassword("qufeiyan");
                generateTempUsernameAndPassword("linghuchong");
                generateTempUsernameAndPassword("yilin");
                generateTempUsernameAndPassword("huangrong");
                generateTempUsernameAndPassword("shangguanyun");
                generateTempUsernameAndPassword("xiangwentian");
                generateTempUsernameAndPassword("xiaolongnv");
                generateTempUsernameAndPassword("luwushuang");
                generateTempUsernameAndPassword("gongsunzhi");
                generateTempUsernameAndPassword("zhaomin");
                generateTempUsernameAndPassword("zhouzhiruo");
                generateTempUsernameAndPassword("guojing");
                generateTempUsernameAndPassword("yuelingshan");


            }

            private void generateTempUsernameAndPassword(String username) {
                ApplicationUser applicationUser2 = new ApplicationUser();
                applicationUser2.setUsername(username);
                applicationUser2.setPassword(bCryptPasswordEncoder.encode(username + "_1"));
                applicationUserRepository.save(applicationUser2);
            }
        };
    }
}
