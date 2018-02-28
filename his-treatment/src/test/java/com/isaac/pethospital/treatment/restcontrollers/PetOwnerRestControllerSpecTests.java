package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.PetOwnerAddPetRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerCreateRequest;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.services.PetOwnerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;

public class PetOwnerRestControllerSpecTests {

    @Mock
    PetOwnerService petOwnerService;

    @InjectMocks
    PetOwnerRestController petOwnerRestController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(petOwnerRestController)
                .build();
    }

    @Test
    public void givenPetOwnerCreateRequestWithoutNameSpecifiedWhenCreateOwnerThenReturn4XX() throws Exception {
        this.mockMvc.perform(post("/owners/create-pet-owner").content("{\"cellPhone\":\"123\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void givenPetOwnerCreateRequestWithNameSpecifiedWhenCreateOwnerThenReturn200() throws Exception {
        this.mockMvc.perform(post("/owners/create-pet-owner").content("{\"name\":\"isaac\",\"cellPhone\":\"123\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(petOwnerService, times(1)).createPetOwner(any(PetOwnerCreateRequest.class));
    }

    @Test
    public void givenPetCreateRequestWithNameSpecifiedWhenAddPetThenReturn200() throws Exception {
        this.mockMvc.perform(post("/owners/add-pet").content("{\"name\":\"笨笨\",\"age\":1}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(petOwnerService, times(1)).addPet(any(PetOwnerAddPetRequest.class));
    }


    @Test
    public void givenPetOwnerRestControllerWhenFindByMemberNumberThenReturnPetOwner() throws Exception {

        PetOwnerEntity petOwnerEntity = getPetOwnerEntity();
        doReturn(petOwnerEntity).when(petOwnerService).findByMemberNumber("123");

        this.mockMvc.perform(get("/owners/find-by-member-number/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.memberNumber", is("123")));
    }

    @Test
    public void givenPetOwnerRestControllerWhenFindByNameThenReturnPetOwnerList() throws Exception {

        PetOwnerEntity petOwnerEntity = getPetOwnerEntity();
        List<PetOwnerEntity> list = new LinkedList<>();
        list.add(petOwnerEntity);
        doReturn(list).when(petOwnerService).findByName("刘备");

        this.mockMvc.perform(post("/owners/find-by-name").content("{\"name\":\"刘备\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("刘备")));

        verify(petOwnerService, times(1)).findByName("刘备");
    }

    private PetOwnerEntity getPetOwnerEntity() {
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setMemberNumber("123");
        petOwnerEntity.setName("刘备");
        return petOwnerEntity;
    }
}
