package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementGoodEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProcurementRequestOperation {

    Long id;
    String requester;
    List<ProcurementGoodEntity> goods = new LinkedList<>();
    LocalDateTime submittedData;
    ProcurementEntity procurement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public List<ProcurementGoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<ProcurementGoodEntity> goods) {
        this.goods = goods;
    }


    public LocalDateTime getSubmittedData() {
        return submittedData;
    }

    public void setSubmittedData(LocalDateTime submittedData) {
        this.submittedData = submittedData;
    }

    public ProcurementEntity getProcurement() {
        return procurement;
    }

    public void setProcurement(ProcurementEntity procurement) {
        this.procurement = procurement;
    }

    public ProcurementRequestEntity toProcurementRequestEntity() {
        ProcurementRequestEntity pro=new ProcurementRequestEntity();
        assignValues(pro);
        return pro;
    }

    private void assignValues(ProcurementRequestEntity pro) {
        this.goods.forEach(r->{
            pro.addGood(r);
        });
        pro.setRequester(this.requester);
    }
}
