package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.LinkedList;
import java.util.List;

import static com.isaac.pethospital.common.test.TestHelper.asJsonString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EmployeeRestControllerSpecTests {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeRestController employeeRestController;

    private MockMvc mockMvc;
    EmployeeEntity employeeEntity;

    @Before
    public void setup() {
        employeeEntity = new EmployeeEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(employeeRestController)
                .build();
    }

    @Test
    public void whenFindByEmployeeTypeThenReturnEmployeeList() throws Exception {

        List<EmployeeEntity> list = new LinkedList<>();
        employeeEntity.setName("黄蓉");
        list.add(employeeEntity);
        EmployeeOperationRequest request = new EmployeeOperationRequest();
        request.setEmployeeTypeId(1L);
        doReturn(list).when(this.employeeService).findByEmployeeType(any(EmployeeOperationRequest.class));

        this.mockMvc.perform(post("/employees/find-by-employee-type").content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("黄蓉")));
    }

    @Test
    public void whenFindByDepartmentThenReturnEmployeeList() throws Exception {

        List<EmployeeEntity> list = new LinkedList<>();
        employeeEntity.setName("黄蓉");
        list.add(employeeEntity);
        EmployeeOperationRequest request = new EmployeeOperationRequest();
        request.setEmployeeTypeId(1L);
        doReturn(list).when(this.employeeService).findByDepartment(any(EmployeeOperationRequest.class));

        this.mockMvc.perform(post("/employees/find-by-department").content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("黄蓉")));
    }
}
