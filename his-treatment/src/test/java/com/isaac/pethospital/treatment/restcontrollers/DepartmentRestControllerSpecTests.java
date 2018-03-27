package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.services.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static com.isaac.pethospital.common.test.TestHelper.asJsonString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DepartmentRestControllerSpecTests {

    @Mock
    DepartmentService departmentService;

    @InjectMocks
    DepartmentRestController departmentRestController;

    private MockMvc mockMvc;
    DepartmentEntity departmentEntity;

    @Before
    public void setup() {
        departmentEntity=new DepartmentEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(departmentRestController)
                .build();
    }


    @Test
    public void givenDepartmentRestControllerWhenGetDepartmentsThenReturnList() throws Exception {

        List<DepartmentEntity> list=new LinkedList<>();
        departmentEntity.setName("全科");
        list.add(departmentEntity);
        doReturn(list).when(departmentService).getDepartments();

        this.mockMvc.perform(get("/departments")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("全科")));

    }



}
