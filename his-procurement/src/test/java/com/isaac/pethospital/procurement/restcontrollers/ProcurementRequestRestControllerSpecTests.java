package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.ProcurementRequestOperation;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.services.ProcurementRequestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.isaac.pethospital.common.test.TestHelper.asJsonString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProcurementRequestRestControllerSpecTests {

    @Mock
    ProcurementRequestService service;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    ProcurementRequestRestController restController;


    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .build();

    }

    @Test
    public void givenRequestWhenCreateProcurementRequestThen() throws Exception {
        ProcurementRequestEntity procurementRequestEntity = new ProcurementRequestEntity();
        ProcurementRequestOperation pro=new ProcurementRequestOperation();

        doReturn(true).when(this.service).createRequest(any(ProcurementRequestOperation.class));

        this.mockMvc.perform(post("/procurement-request/create").content(asJsonString(pro)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)));
    }
}
