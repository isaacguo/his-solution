package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.treatment.dtos.CommentOperationRequest;
import com.isaac.pethospital.treatment.entities.CommentEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import com.isaac.pethospital.treatment.repositories.CommentRepository;
import com.isaac.pethospital.treatment.repositories.TreatmentCaseRepository;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl extends AbstractCrudService<CommentEntity, CommentOperationRequest> implements CommentService<CommentEntity, CommentOperationRequest> {


    private final CommentRepository commentRepository;
    private final TreatmentCaseRepository treatmentCaseRepository;

    public CommentServiceImpl(CommentRepository jpaRepository, TreatmentCaseRepository treatmentCaseRepository) {
        super(jpaRepository);
        this.commentRepository = jpaRepository;
        this.treatmentCaseRepository = treatmentCaseRepository;
    }

    @Override
    public CommentEntity create(CommentOperationRequest request) {
        TreatmentCaseEntity tce = this.treatmentCaseRepository.findByUuid(request.getTreatmentCaseUuid());
        if (tce == null)
            throw new RuntimeException("Cannot find tce");
        CommentEntity ce = new CommentEntity();
        ce.setComments(request.getContent());
        ce.setCreatedDate(LocalDateTime.now());
        tce.addComment(ce);
        this.treatmentCaseRepository.save(tce);
        return ce;
    }

    @Override
    public CommentEntity update(CommentOperationRequest request) {
        return null;
    }

    @Override
    public List<CommentEntity> findByTreatmentCaseUuid(String uuid) {
        TreatmentCaseEntity tce = this.treatmentCaseRepository.findByUuid(uuid);
        if(tce==null)
            throw new RuntimeException("Cannot find tce");
        else
            return tce.getComments();
    }
}
