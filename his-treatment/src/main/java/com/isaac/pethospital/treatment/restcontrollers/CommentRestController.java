package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.treatment.dtos.CommentOperationRequest;
import com.isaac.pethospital.treatment.entities.CommentEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/comments")
public class CommentRestController extends AbstractCRUDRestController<CommentEntity, CommentOperationRequest> {

    public CommentRestController(CrudService<CommentEntity, CommentOperationRequest> crudService) {
        super(crudService);
    }
}
