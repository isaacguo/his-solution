package com.isaac.hisemployeemanagement.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

    @GetMapping
    public String getEmployee()
    {
        return "ok";
    }

}
