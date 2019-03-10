package com.isaac.pethospital.common.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthHelper {

    public String getUserAccount() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
