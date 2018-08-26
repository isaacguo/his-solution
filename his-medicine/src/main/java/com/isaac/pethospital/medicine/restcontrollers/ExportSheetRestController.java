package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.dtos.ExportSheetOperationRequest;
import com.isaac.pethospital.medicine.dtos.ImportSheetOperationRequest;
import com.isaac.pethospital.medicine.entities.ExportSheetEntity;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("export-sheets")
public class ExportSheetRestController extends AbstractCRUDRestController<ExportSheetEntity, ExportSheetOperationRequest> {

    public ExportSheetRestController(CrudService<ExportSheetEntity, ExportSheetOperationRequest> crudService) {
        super(crudService);
    }

}
