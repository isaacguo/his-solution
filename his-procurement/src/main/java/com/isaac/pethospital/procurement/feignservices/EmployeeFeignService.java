package com.isaac.pethospital.procurement.feignservices;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="HisEmployee")
public interface EmployeeFeignService {

    @RequestMapping(method = RequestMethod.GET, value = "/employees/{userAccount}/manager/")
    String findDirectReportManagerUserAccount(@PathVariable("userAccount") String userAccount);

}
