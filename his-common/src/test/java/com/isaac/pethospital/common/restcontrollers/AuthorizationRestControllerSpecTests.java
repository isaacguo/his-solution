package com.isaac.pethospital.common.restcontrollers;

import com.isaac.pethospital.common.dtos.AuthorizationOperationRequest;
import com.isaac.pethospital.common.entities.AuthorizationEntity;
import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.common.services.AuthorizationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.persistence.ManyToMany;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AuthorizationRestControllerSpecTests {

    @Mock
    AuthorizationService authorizationService;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    AuthorizationRestController authorizationRestController;

    private MockMvc mockMvc;
    AuthorizationEntity authorizationEntity;

    @Before
    public void setup() {
        authorizationEntity = new AuthorizationEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(authorizationRestController)
                .build();
    }


    @Test
    public void givenIdThenDeleteAuthorization() throws Exception {

        doReturn(true).when(this.authorizationService).deleteById(1L);

        this.mockMvc.perform(delete("/authorizations/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void createAuthorizationEntity() throws Exception {

        doReturn(true).when(this.authorizationService).createAuthorization(any(AuthorizationOperationRequest.class));
        this.mockMvc.perform(post("/authorizations/create").content(asJsonString(authorizationEntity)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));

    }

    @Test
    public void updateAuthorization() throws Exception {

        AuthorizationOperationRequest authorizationOperationRequest=new AuthorizationOperationRequest();
        doReturn(true).when(this.authorizationService).updateAuthorization(any(AuthorizationOperationRequest.class));
        this.mockMvc.perform(put("/authorizations/update").content(asJsonString(authorizationOperationRequest)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));
    }

    @Test
    public void isAuthorized() throws Exception{


        doReturn("Isaac").when(authHelper).getUserAccount();
        doReturn(true).when(this.authorizationService).isAuthorized("Isaac",2L,3L);

        this.mockMvc.perform(get("/authorizations/isAuthorized/2/3"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));


    }
}

