package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.ProcurementApprovalOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.services.ProcurementApprovalService;
import org.apache.http.entity.ContentType;
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
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProcurementApprovalRestControllerSpecTests {

    @Mock
    ProcurementApprovalService service;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    ProcurementApprovalRestController restController;


    private MockMvc mockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .build();

    }

    @Test
    public void whenGetApprovalWorkflowThenReturnRoot() throws Exception {

        ProcurementApprovalStageEntity pae = new ProcurementApprovalStageEntity();
        pae.setStage("申请人");

        doReturn(pae).when(this.service).getRoot();

        this.mockMvc.perform(get("/procurement-approval"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.stage", is("申请人")));
    }

    @Test
    public void whenGetUnfinishedApprovalThenReturnList() throws Exception {
        ProcurementEntity procurementEntity = new ProcurementEntity();
        procurementEntity.setOrderNumber("001");
        ProcurementApprovalEntity procurementApprovalEntity = new ProcurementApprovalEntity();
        procurementApprovalEntity.setProcurement(procurementEntity);

        List<ProcurementEntity> list = new LinkedList<>();
        list.add(procurementEntity);
        doReturn("Isaac").when(authHelper).getUserAccount();
        doReturn(list).when(this.service).findMyUnfinishedApprovalProcurements("Isaac");
        this.mockMvc.perform(get("/procurement-approval/approvals"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].orderNumber", is("001")));
    }

    @Test
    public void whenUpdateApprovalThenDoIt() throws Exception {
        ProcurementApprovalOperationRequest request = new ProcurementApprovalOperationRequest();
        request.setComments("OK");
        request.setReviewResult(true);
        this.mockMvc.perform(post("/procurement-approval/update").content(asJsonString(request)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}

