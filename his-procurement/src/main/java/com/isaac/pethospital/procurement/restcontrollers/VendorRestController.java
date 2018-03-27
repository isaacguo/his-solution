package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.services.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vendors")
public class VendorRestController {


    private final VendorService vendorService;
    private final AuthHelper authHelper;

    public VendorRestController(AuthHelper authHelper, VendorService vendorService) {
        this.authHelper = authHelper;
        this.vendorService = vendorService;
    }


    @GetMapping
    public List<VendorEntity> findAll()
    {
        return this.vendorService.findAll();
    }
    @PostMapping("find-vendor-by-name")
    public VendorEntity findByTitle(@RequestBody VendorOperationRequest request){
        return this.vendorService.findByName(request);
    }


    @PostMapping("create-vendor")
    public VendorEntity createVendor(@RequestBody VendorOperationRequest request) {
        return this.vendorService.createVendor(request);
    }

    @PostMapping("delete-vendor")
    public boolean deleteVendor(@RequestBody VendorOperationRequest request) {
        return this.vendorService.deleteVendor(request);
    }

    @PostMapping("update-vendor")
    public VendorEntity updateVendor(@RequestBody VendorOperationRequest request) {
        return this.vendorService.updateVendor(request);
    }


}
