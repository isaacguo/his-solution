package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.treatment.entities.CommentEntity;

import java.util.List;

public interface CommentService <T, R> extends CrudService<T, R> {

    List<CommentEntity> findByTreatmentCaseUuid(String uuid);
}
