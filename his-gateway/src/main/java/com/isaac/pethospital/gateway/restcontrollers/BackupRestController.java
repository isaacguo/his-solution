package com.isaac.pethospital.gateway.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.gateway.entities.BackupEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data-management")
public class BackupRestController extends AbstractCRUDRestController<BackupEntity,BackupEntity> {

    public BackupRestController(CrudService<BackupEntity, BackupEntity> crudService) {
        super(crudService);
    }


}
