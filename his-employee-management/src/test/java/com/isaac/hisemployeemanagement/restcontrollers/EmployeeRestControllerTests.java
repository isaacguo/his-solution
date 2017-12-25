package com.isaac.hisemployeemanagement.restcontrollers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRestControllerTests {

    //@Mock
    //private EmployeeRestController employeeRestController;

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
    public void whenGetApplicationsThenGetApplicationIsInvoked() throws Exception {
        this.mockMvc.perform(get("/employee")).andExpect(status().isOk());
        //verify(applicationService, times(1)).getApplications();
    }


}
