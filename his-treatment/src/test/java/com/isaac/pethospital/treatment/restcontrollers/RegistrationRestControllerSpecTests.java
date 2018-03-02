package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.services.RegistrationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RegistrationRestControllerSpecTests {

    @Mock
    RegistrationService registrationService;

    @InjectMocks
    RegistrationRestController registrationRestController;

    private MockMvc mockMvc;
    RegistrationEntity registrationEntity;

    @Before
    public void setup() {
        registrationEntity=new RegistrationEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(registrationRestController)
                .build();
    }

    @Test
    public void givenRegistrationOperationWhenCreateRegistrationThenCreateInRegistrationServiceIsInvoked() throws Exception {
        
        registrationEntity = new RegistrationEntity();
        RegistrationOperationRequest request = getRegistrationRequest();

        doReturn(registrationEntity).when(registrationService).createRegistration(request);

        //this.mockMvc.perform(post("/registrations/create-registration").content("{\"indexOfDay\":0,\"id\":null,\"bookDate\":\"2018-03-02 08:30:48\",\"doctorId\":1,\"operatorId\":2,\"petId\":1}")
        this.mockMvc.perform(post("/registrations/create-registration").content("{\"indexOfDay\":0,\"id\":null,\"doctorId\":1,\"operatorId\":2,\"petId\":1}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(registrationService, times(1)).createRegistration(any(RegistrationOperationRequest.class));
    }

    @Test
    public void whenFindRegistrationThenServiceIsInvoked() throws Exception
    {
        this.mockMvc.perform(post("/registrations/find-by-doctor-and-bookdate-after").content("{\"indexOfDay\":0,\"id\":null,\"doctorId\":1,\"operatorId\":2,\"petId\":1}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(registrationService,times(1)).findByDoctorAndBookDateAfter(any(RegistrationOperationRequest.class));
    }

    private RegistrationOperationRequest getRegistrationRequest() {
        RegistrationOperationRequest registrationOperationRequest = new RegistrationOperationRequest();
        registrationOperationRequest.setBookDate(LocalDateTime.now());
        registrationOperationRequest.setPetId(1L);
        registrationOperationRequest.setDoctorId(1L);
        registrationOperationRequest.setOperatorId(2L);
        return registrationOperationRequest;
    }


}
