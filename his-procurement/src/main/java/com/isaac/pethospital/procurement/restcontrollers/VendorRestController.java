package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.services.VendorService;
import org.springframework.security.access.method.P;
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

    @GetMapping("/permitted")
    public List<VendorEntity> findPermittedAll()
    {
        String userAccount=authHelper.getUserAccount();
        return this.vendorService.findPermittedAll(userAccount);
    }

    @GetMapping
    public List<VendorEntity> findAll()
    {
        return this.vendorService.findAll();
    }

    @GetMapping("{id}")
    public VendorEntity findById(@PathVariable("id") Long id)
    {
        return this.vendorService.findById(id);
    }
    @PostMapping("find-vendor-by-name")
    public VendorEntity findByTitle(@RequestBody VendorOperationRequest request){
        return this.vendorService.findByName(request);
    }
    @GetMapping("find-by-name-contains/{keyword}")
    public List<VendorEntity> findByNameContains(@PathVariable("keyword") String keyword){
        return this.vendorService.findByNameContains(keyword);
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
    @PutMapping("move-vendor")
    public boolean moveVendor(@RequestBody VendorOperationRequest request )
    {
        return this.vendorService.moveVendor(request);
    }



}
