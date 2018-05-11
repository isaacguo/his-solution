package com.isaac.pethospital.common.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.security.AlgorithmConstraints;
import java.util.LinkedList;
import java.util.List;

@Entity
public class TopicOperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne
    @JsonBackReference("AuthorizationTopicEntity-TopicOperationEntity")
    AuthorizationTopicEntity authorizationTopic;

    @ManyToMany()
    @JsonBackReference("AuthorizationAssignmentEntity-TopicOperationEntity")
    List<AuthorizationAssignmentEntity> authorizationAssignmentList = new LinkedList<>();

    public List<AuthorizationAssignmentEntity> getAuthorizationAssignmentList() {
        return authorizationAssignmentList;
    }

    public void addAuthorizationAssignment(AuthorizationAssignmentEntity authorizationAssignment) {
        this.authorizationAssignmentList.add(authorizationAssignment);
    }

    public void removeAuthorizationAssignment(AuthorizationAssignmentEntity authorizationAssignment) {
        this.authorizationAssignmentList.remove(authorizationAssignment);
    }

    public AuthorizationTopicEntity getAuthorizationTopic() {
        return authorizationTopic;
    }

    public void setAuthorizationTopic(AuthorizationTopicEntity authorizationTopic) {
        this.authorizationTopic = authorizationTopic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
