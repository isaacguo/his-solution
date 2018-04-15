package com.isaac.pethospital.procurement.feignservices;

import com.isaac.pethospital.procurement.dtos.DepartmentIdAndName;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "HisEmployee")
public interface EmployeeFeignService {

    @RequestMapping(method = RequestMethod.GET, value = "/employees/{userAccount}/manager/")
    String findDirectReportManagerUserAccount(@PathVariable("userAccount") String userAccount);

    @RequestMapping(method = RequestMethod.POST, value = "/employees/find-by-title/")
    String findByTitle(@RequestBody EmployeeOperationRequest request);

    @RequestMapping(method = RequestMethod.GET, value = "/employees/find-by-userAccount/{userAccount}")
    EmployeeOperationRequest findUserNameByUserAccount(@PathVariable("userAccount") String userAccount);

    @RequestMapping(method = RequestMethod.GET, value = "/departments/brief")
    List<DepartmentIdAndName> findIndexAndNameOnly();
}
