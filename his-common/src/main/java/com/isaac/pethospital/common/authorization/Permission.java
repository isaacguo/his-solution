package com.isaac.pethospital.common.authorization;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Permission {

    private String domain;
    private String subdomain;
    private String action;


}
