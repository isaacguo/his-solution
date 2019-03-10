package com.isaac.pethospital.treatment.feignservices;

import com.isaac.pethospital.treatment.dtos.DepartmentIdAndName;
import com.isaac.pethospital.treatment.dtos.EmployeeListItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "HisEmployee")
public interface EmployeeFeignService {

    /*
    @RequestMapping(method = RequestMethod.GET, value = "/employees/{userAccount}/manager/")
    String findDirectReportManagerUserAccount(@PathVariable("userAccount") String userAccount);

    @RequestMapping(method = RequestMethod.POST, value = "/employees/find-by-title/")
    String findByTitle(@RequestBody EmployeeOperationRequest request);

    @RequestMapping(method = RequestMethod.GET, value = "/employees/find-by-userAccount/{userAccount}")
    EmployeeOperationRequest findUserNameByUserAccount(@PathVariable("userAccount") String userAccount);
    */


    @RequestMapping(method = RequestMethod.GET, value = "/departments/brief")
    List<DepartmentIdAndName> findIndexAndNameOnly();

    @GetMapping(value = "/employees/{departmentId}/employee-list")
    List<EmployeeListItem> findEmployeesForEmployeeListItemByDepartmentId(@PathVariable("departmentId") Long departmentId);

    /*
    @GetMapping("/employees/get-department-id/{userAccount}")
    public Long getDepartmentId(@PathVariable("userAccount") String userAccount);
    */
}
