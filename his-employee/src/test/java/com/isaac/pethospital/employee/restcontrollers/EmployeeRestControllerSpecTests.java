package com.isaac.pethospital.employee.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.employee.dto.EmployeeOperationRequest;
import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.services.EmployeeService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeRestControllerSpecTests {

    @Mock
    private EmployeeService employeeService;
    @Mock
    private AuthHelper authHelper;

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


    @Test
    public void whenCreateEmployeeThenInvokeService() throws Exception {

        EmployeeOperationRequest request = new EmployeeOperationRequest();
        //request.setName("Isaac");
        EmployeeEntity ee = new EmployeeEntity();
        ee.setId(1L);
        doReturn(true).when(this.employeeService).createEmployee(any(EmployeeOperationRequest.class));
        doReturn("Isaac").when(authHelper).getUserAccount();

        this.mockMvc.perform(post("/employees/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void whenDeleteEmployeeThenInvokeService() throws Exception {

        EmployeeOperationRequest request = new EmployeeOperationRequest();
        //request.setName("Isaac");
        EmployeeEntity ee = new EmployeeEntity();
        ee.setId(1L);
        //ee.setName("Isaac");
        doReturn("Isaac").when(authHelper).getUserAccount();

        this.mockMvc.perform(delete("/employees/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk());
    }


    @Test
    public void whenUpdateEmployeeThenInvokeService() throws Exception {

        EmployeeOperationRequest request = new EmployeeOperationRequest();
        //request.setName("Isaac");
        EmployeeEntity ee = new EmployeeEntity();
        ee.setId(1L);
        //ee.setName("Isaac");
        doReturn(true).when(this.employeeService).updateEmployee(any(EmployeeOperationRequest.class));
        doReturn("Isaac").when(authHelper).getUserAccount();

        this.mockMvc.perform(put("/employees/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void findByKeyword() throws Exception {

        EmployeeEntity ee=new EmployeeEntity();
        ee.setGivenName("Isaac");
        List<EmployeeEntity> list=new LinkedList<>();
        list.add(ee);
        doReturn(list).when(this.employeeService).findKeywordInName(any(String.class));

        this.mockMvc.perform(get("/employees/search-by-name/isaac"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].givenName", is("Isaac")));
    }



}
