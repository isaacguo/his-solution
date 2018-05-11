package com.isaac.pethospital.common.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class AuthorizationTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @OneToMany(mappedBy = "authorizationTopic",cascade = CascadeType.ALL)
    @JsonManagedReference("AuthorizationTopicEntity-TopicOperationEntity")
    List<TopicOperationEntity> availableTopicOperationList = new LinkedList<>();
    public AuthorizationTopicEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<TopicOperationEntity> getAvailableTopicOperationList() {
        return availableTopicOperationList;
    }

    public void addAvailableTopicOperation(TopicOperationEntity topicOperation) {
        if (topicOperation == null)
            throw new RuntimeException("Topic Operation is null");
        topicOperation.setAuthorizationTopic(this);
        this.availableTopicOperationList.add(topicOperation);
    }

    public void addAvailableTopicOperationByName(String name) {
        if(StringUtils.isEmpty(name))
            throw new RuntimeException("Topic name is empty");
       TopicOperationEntity topicOperationEntity=new TopicOperationEntity();
       topicOperationEntity.setName(name);
       this.addAvailableTopicOperation(topicOperationEntity);
    }

    public void removeAvailableTopicOperation(TopicOperationEntity topicOperation) {
        if (topicOperation == null)
            throw new RuntimeException("Topic Operation is null");
        topicOperation.setAuthorizationTopic(null);
        this.availableTopicOperationList.add(topicOperation);
    }
}
