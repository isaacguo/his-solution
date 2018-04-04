package com.isaac.pethospital.procurement.restcontrollers;


import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.services.ProcurementService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProcurementRestControllerSpecTests {

    @Mock
    ProcurementService service;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    ProcurementRestController restController;


    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .build();

    }


    @Test
    public void givenGetAllMyProcurementsThenReturnMyProcurements() throws Exception {

        ProcurementEntity pe = new ProcurementEntity();
        pe.setOrderNumber("001");
        List<ProcurementEntity> list = new LinkedList<>();
        list.add(pe);

        doReturn("Isaac").when(authHelper).getUserAccount();
        doReturn(list).when(this.service).findAllMyProcurements("Isaac");

        this.mockMvc.perform(get("/procurements/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].orderNumber", is("001")));
    }

    @Test
    public void whenGetAllMyProcurementsByPurchaseAssigneeThenReturnListOfMyAssignedProcurements() throws Exception {


        ProcurementEntity pe = new ProcurementEntity();
        pe.setOrderNumber("001");
        List<ProcurementEntity> list = new LinkedList<>();
        list.add(pe);

        doReturn("Isaac").when(authHelper).getUserAccount();
        doReturn(list).when(this.service).findMyProcurementsByPurchaseByAssignee("Isaac");

        this.mockMvc.perform(get("/procurements/user/purchases"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].orderNumber", is("001")));

    }
}
