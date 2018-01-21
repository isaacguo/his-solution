package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.common.authorization.Permission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionRestController {

    List<Permission> getPermissions() {
        Permission p1 = new Permission("employee", "salary","CRUD");
        List<Permission> plist = new LinkedList<>();
        plist.add(p1);
        return plist;
    }

}
