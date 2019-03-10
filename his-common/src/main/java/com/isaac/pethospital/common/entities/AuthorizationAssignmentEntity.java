package com.isaac.pethospital.common.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class AuthorizationAssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JsonBackReference("AuthorizationEntity-AuthorizationAssignmentEntity")
    AuthorizationEntity authorization;

    @ManyToOne
    AuthorizationTopicEntity topic;

    @ManyToMany()
    @JsonManagedReference("AuthorizationAssignmentEntity-TopicOperationEntity")
    List<TopicOperationEntity> allowedOperations = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorizationTopicEntity getTopic() {
        return topic;
    }

    public void setTopic(AuthorizationTopicEntity topic) {
        this.topic = topic;
    }

    public List<TopicOperationEntity> getAllowedOperations() {
        return allowedOperations;
    }

    public void addAllowedOperation(TopicOperationEntity allowedOperation) {
        if (allowedOperation == null)
            throw new RuntimeException("Allowed Operation is null");
        allowedOperation.addAuthorizationAssignment(this);
        this.allowedOperations.add(allowedOperation);
    }

    public void removeAllowedOperation(TopicOperationEntity allowedOperation) {
        if (allowedOperation == null)
            throw new RuntimeException("Allowed Operation is null");
        allowedOperation.removeAuthorizationAssignment(this);
        this.allowedOperations.remove(allowedOperation);
    }

    public AuthorizationEntity getAuthorization() {
        return authorization;
    }

    public void setAuthorization(AuthorizationEntity authorization) {
        this.authorization = authorization;
    }
}
