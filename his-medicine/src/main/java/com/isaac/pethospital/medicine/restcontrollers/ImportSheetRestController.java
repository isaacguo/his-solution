package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.dtos.ImportSheetOperationRequest;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("import-sheets")
public class ImportSheetRestController extends AbstractCRUDRestController<ImportSheetEntity, ImportSheetOperationRequest> {

    public ImportSheetRestController(CrudService<ImportSheetEntity, ImportSheetOperationRequest> crudService) {
        super(crudService);
    }

}
