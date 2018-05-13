package com.isaac.pethospital.gateway.feignservices;

import com.isaac.pethospital.gateway.dtos.EmployeeOperationRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "HisEmployee")
public interface EmployeeFeignService {

    @RequestMapping(method = RequestMethod.GET, value = "/employees/find-by-loginAccount/{loginAccount}")
    EmployeeOperationRequest findUserNameByLoginAccount(@PathVariable("loginAccount") String loginAccount);
}
