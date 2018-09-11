package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.treatment.dtos.CommentOperationRequest;
import com.isaac.pethospital.treatment.entities.CommentEntity;
import com.isaac.pethospital.treatment.repositories.CommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends AbstractCrudService<CommentEntity, CommentOperationRequest> implements CommentService<CommentEntity, CommentOperationRequest> {


    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository jpaRepository) {
        super(jpaRepository);
        this.commentRepository = jpaRepository;
    }

    @Override
    public CommentEntity create(CommentOperationRequest request) {
        return null;
    }

    @Override
    public CommentEntity update(CommentOperationRequest request) {
        return null;
    }
}
