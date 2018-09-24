package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.treatment.dtos.CommentOperationRequest;
import com.isaac.pethospital.treatment.entities.CommentEntity;
import com.isaac.pethospital.treatment.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comments")
public class CommentRestController extends AbstractCRUDRestController<CommentEntity, CommentOperationRequest> {

    private final CommentService commentService;
    private final AuthHelper authHelper;

    public CommentRestController(CommentService commentService, AuthHelper authHelper) {
        super(commentService);
        this.commentService = commentService;
        this.authHelper = authHelper;
    }

    @PostMapping("/create-comment")
    public CommentEntity createComment(@RequestBody CommentOperationRequest request)
    {
        return null;
    }

    @GetMapping("/find-by-treatment-case-uuid/{uuid}")
    public List<CommentEntity> findByTreatmentCaseUuid(@PathVariable("uuid") String uuid) {

        return this.commentService.findByTreatmentCaseUuid(uuid);
    }
}
