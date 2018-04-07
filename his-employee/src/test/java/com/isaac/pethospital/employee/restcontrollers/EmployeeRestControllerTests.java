package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import com.isaac.pethospital.employee.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeRestControllerTests {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeRestController employeeRestController;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(employeeRestController)
                .build();

    }


    @Test
    public void whenFindByUserAccountThenReturnUserFullName() throws Exception {

        EmployeeOperationRequest employeeOperationRequest=new EmployeeOperationRequest();
        employeeOperationRequest.setFullName("郭靖");
        doReturn(employeeOperationRequest).when(this.employeeService).findUserNameByUserAccount("Isaac");
        this.mockMvc.perform(get("/employees/find-by-userAccount/Isaac"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is("郭靖")));

    }

}
