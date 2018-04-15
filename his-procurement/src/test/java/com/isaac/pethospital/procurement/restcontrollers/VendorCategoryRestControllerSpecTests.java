package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.services.VendorCategoryService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VendorCategoryRestControllerSpecTests {

    @Mock
    VendorCategoryService vendorCategoryService;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    VendorCategoryRestController vendorCategoryRestController;


    private MockMvc mockMvc;
    VendorCategoryEntity vendorCategoryEntity;

    @Before
    public void setup() {
        vendorCategoryEntity = new VendorCategoryEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(vendorCategoryRestController)
                .build();
    }

    @Test
    public void whenFindAllThenReturnList() throws Exception {

        VendorCategoryEntity vendorCategoryEntity1 = new VendorCategoryEntity();
        vendorCategoryEntity1.setName("abc");
        VendorCategoryEntity vendorCategoryEntity2 = new VendorCategoryEntity();
        vendorCategoryEntity2.setName("bcd");
        List<VendorCategoryEntity> list = new LinkedList<>();
        list.add(vendorCategoryEntity1);
        list.add(vendorCategoryEntity2);

        doReturn(list).when(this.vendorCategoryService).findAll();

        this.mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("abc")));
    }

    @Test
    public void findAllForListThenReturnList() throws Exception {

        VendorCategoryEntity vendorCategoryEntity1 = new VendorCategoryEntity();
        vendorCategoryEntity1.setName("abc");
        VendorCategoryEntity vendorCategoryEntity2 = new VendorCategoryEntity();
        vendorCategoryEntity2.setName("bcd");
        List<VendorCategoryEntity> list = new LinkedList<>();
        list.add(vendorCategoryEntity1);
        list.add(vendorCategoryEntity2);

        doReturn(list).when(this.vendorCategoryService).findVendorProductCategoryEntityByParentIsNull();

        this.mockMvc.perform(get("/categories/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("abc")));
    }


    @Test
    public void findByIdForListThenReturnList() throws Exception {

        VendorCategoryEntity vendorCategoryEntity1 = new VendorCategoryEntity();
        vendorCategoryEntity1.setId(1L);
        vendorCategoryEntity1.setName("abc");

        doReturn(vendorCategoryEntity1).when(this.vendorCategoryService).findById(1L);

        this.mockMvc.perform(get("/categories/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("abc")));
    }
}
