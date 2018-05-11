package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.services.ProcurementStatusService;
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
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProcurementStatusRestControllerSpecTests {

    @Mock
    ProcurementStatusService service;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    ProcurementStatusRestController restController;


    private MockMvc mockMvc;
    ProcurementStatusEntity vendorEntity;

    @Before
    public void setup() {
        vendorEntity = new ProcurementStatusEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .build();

    }

    @Test
    public void whenGetRootThenGetRoot() throws Exception {
        ProcurementStatusEntity procurementStatusEntity = new ProcurementStatusEntity();
        procurementStatusEntity.setStatus("abc");

        doReturn(procurementStatusEntity).when(this.service).getRoot();

        this.mockMvc.perform(get("/procurement-status/root"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status", is("abc")));
    }
}
