package com.isaac.pethospital.common.dtos;

import java.util.LinkedList;
import java.util.List;

public class AuthorizationAssignmentOperationRequest {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public List<Long> getAllowedOperationIds() {
        return allowedOperationIds;
    }

    public void setAllowedOperationIds(List<Long> allowedOperationIds) {
        this.allowedOperationIds = allowedOperationIds;
    }

    Long id;
    Long topicId;
    List<Long> allowedOperationIds = new LinkedList<>();
}
