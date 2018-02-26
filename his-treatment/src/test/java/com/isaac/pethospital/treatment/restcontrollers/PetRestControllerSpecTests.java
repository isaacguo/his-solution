package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.services.PetService;
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

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PetRestControllerSpecTests {

    @Mock
    PetService petService;

    @InjectMocks
    PetRestController petRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(petRestController)
                .build();
    }

    @Test
    public void givenPetRestControllerWhenFindByNameThenReturnPetList() throws Exception {

        PetEntity petEntity = getPetEntity();
        List<PetEntity> list=new LinkedList<>();
        list.add(petEntity);
        doReturn(list).when(petService).findByName("笨笨");

        this.mockMvc.perform(post("/pets/find-by-name").content("{\"name\":\"笨笨\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("笨笨")));

        verify(petService,times(1)).findByName("笨笨");
    }

    private PetEntity getPetEntity() {
        PetEntity petEntity = new PetEntity();
        petEntity.setName("笨笨");
        return petEntity;
    }
}
