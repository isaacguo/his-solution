package com.isaac.pethospital.treatment.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DepartmentOperationRequest {

    private Long id;
    private Long depId;
    private String name;
    private String description;
    private boolean exposeToPublic;
    private boolean openToFrontDesk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isExposeToPublic() {
        return exposeToPublic;
    }

    public void setExposeToPublic(boolean exposeToPublic) {
        this.exposeToPublic = exposeToPublic;
    }

    public boolean isOpenToFrontDesk() {
        return openToFrontDesk;
    }

    public void setOpenToFrontDesk(boolean openToFrontDesk) {
        this.openToFrontDesk = openToFrontDesk;
    }
}
