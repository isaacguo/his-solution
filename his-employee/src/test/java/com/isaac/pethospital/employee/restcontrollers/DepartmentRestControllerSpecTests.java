package com.isaac.pethospital.department.restcontrollers;


import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.restcontrollers.DepartmentRestController;
import com.isaac.pethospital.employee.services.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DepartmentRestControllerSpecTests {


    @Mock
    private DepartmentService departmentService;
    @Mock
    private AuthHelper authHelper;

    @InjectMocks
    private DepartmentRestController departmentRestController;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(departmentRestController)
                .build();

    }

    @Test
    public void whenFindAllThenReturnAll() throws Exception {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName("ABC");
        List<DepartmentEntity> list = new LinkedList<>();
        list.add(departmentEntity);
        doReturn(list).when(this.departmentService).findAll();
        this.mockMvc.perform(get("/departments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("ABC")));
    }

    @Test
    public void whenFindAllBriefDepartmentThenReturnNameAndIdOnly() throws Exception {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName("ABC");
        List<DepartmentEntity> list = new LinkedList<>();
        list.add(departmentEntity);
        doReturn(list).when(this.departmentService).findIndexAndNameOnly();
        this.mockMvc.perform(get("/departments/brief"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("ABC")));
    }

}
