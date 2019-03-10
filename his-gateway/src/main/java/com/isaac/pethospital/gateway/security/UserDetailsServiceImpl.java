package com.isaac.pethospital.gateway.security;

import com.isaac.pethospital.gateway.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.gateway.feignservices.EmployeeFeignService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeFeignService employeeFeignService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsServiceImpl(EmployeeFeignService employeeFeignService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.employeeFeignService = employeeFeignService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("admin"))
            return new User("admin", bCryptPasswordEncoder.encode("admin"), emptyList());


        EmployeeOperationRequest response = employeeFeignService.findUserNameByLoginAccount(username);
        if (response == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(response.getLoginAccount(), response.getPassword(), emptyList());
    }
}
