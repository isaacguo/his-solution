package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.services.VendorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.AutoPopulatingList;

import javax.transaction.Transactional;

import java.util.LinkedList;
import java.util.List;

import static com.isaac.pethospital.common.test.TestHelper.asJsonString;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VendorRestControllerSpecTests {


    @Mock
    VendorService vendorService;
    @Mock
    AuthHelper authHelper;

    @InjectMocks
    VendorRestController vendorRestController;


    private MockMvc mockMvc;
    VendorEntity vendorEntity;

    @Before
    public void setup() {
        vendorEntity = new VendorEntity();

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(vendorRestController)
                .build();
    }

    @Test
    public void whenFindAllThenReturnList() throws Exception {

        VendorEntity vendorEntity1 = new VendorEntity();
        vendorEntity1.setName("abc");
        VendorEntity vendorEntity2 = new VendorEntity();
        vendorEntity2.setName("bcd");
        List<VendorEntity> list = new LinkedList<>();
        list.add(vendorEntity1);
        list.add(vendorEntity2);

        doReturn(list).when(this.vendorService).findAll();

        this.mockMvc.perform(get("/vendors"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("abc")));
    }

    @Test
    public void whenFindByNameThenReturnVendor() throws Exception {

        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setName("abc");

        VendorOperationRequest request = new VendorOperationRequest();
        request.setName("abc");

        doReturn(vendorEntity).when(this.vendorService).findByName(any(VendorOperationRequest.class));

        this.mockMvc.perform(post("/vendors/find-vendor-by-name").content(asJsonString(request)).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("abc")));
    }


    @Test
    public void whenCreateVendorThenInvokeService() throws Exception {

        VendorOperationRequest request = new VendorOperationRequest();
        request.setName("Isaac");
        VendorEntity ee = new VendorEntity();
        ee.setId(1L);
        ee.setName("Isaac");
        doReturn(ee).when(this.vendorService).createVendor(any(VendorOperationRequest.class));
        doReturn("Isaac").when(authHelper).getUserAccount();

        this.mockMvc.perform(post("/vendors/create-vendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void whenDeleteVendorThenInvokeService() throws Exception {

        VendorOperationRequest request = new VendorOperationRequest();
        request.setName("Isaac");
        VendorEntity ee = new VendorEntity();
        ee.setId(1L);
        ee.setName("Isaac");
        doReturn("Isaac").when(authHelper).getUserAccount();

        this.mockMvc.perform(post("/vendors/delete-vendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk());
    }


    @Test
    public void whenUpdateVendorThenInvokeService() throws Exception {

        VendorOperationRequest request = new VendorOperationRequest();
        request.setName("Isaac");
        VendorEntity ee = new VendorEntity();
        ee.setId(1L);
        ee.setName("Isaac");
        doReturn(ee).when(this.vendorService).updateVendor(any(VendorOperationRequest.class));
        doReturn("Isaac").when(authHelper).getUserAccount();

        this.mockMvc.perform(post("/vendors/update-vendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }


    @Test
    public void whenFindByIdThenReturnVendor() throws Exception {

        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setName("abc");
        vendorEntity.setId(1L);

        VendorOperationRequest request = new VendorOperationRequest();
        request.setName("abc");

        doReturn(vendorEntity).when(this.vendorService).findById(1L);

        this.mockMvc.perform(get("/vendors/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("abc")));
    }

    @Test
    public void whenFindByNameContains() throws Exception {

        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setName("12com3");
        vendorEntity.setId(1L);
        List<VendorEntity> list=new LinkedList<>();
        list.add(vendorEntity);

        doReturn(list).when(this.vendorService).findByNameContains("com");
        this.mockMvc.perform(get("/vendors/find-by-name-contains/com"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", containsString("com")));
    }

}
