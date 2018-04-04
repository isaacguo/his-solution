package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.common.math.DecimalHelper;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestGoodRepository;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProcurementPurchaseOperationRequest {

    LocalDateTime generatedDateTime; //表单生成时间
    Long procurementId;
    List<ProcurementPurchaseGoodEntity> goods = new LinkedList<>();
    private Long id;

    public Long getProcurementId() {
        return procurementId;
    }

    public void setProcurementId(Long procurementId) {
        this.procurementId = procurementId;
    }

    public ProcurementPurchaseEntity toProcurementPurchaseEntity(ProcurementRequestGoodRepository procurementRequestGoodRepository) {
        double totalPrice = 0;
        ProcurementPurchaseEntity pp = new ProcurementPurchaseEntity();

        for (ProcurementPurchaseGoodEntity r : this.goods) {
            ProcurementPurchaseGoodEntity procurementPurchaseGoodEntity = new ProcurementPurchaseGoodEntity();
            procurementPurchaseGoodEntity.setContact(r.getContact());
            procurementPurchaseGoodEntity.setContactTelephone(r.getContactTelephone());
            procurementPurchaseGoodEntity.setVendor(r.getVendor());
            procurementPurchaseGoodEntity.setNumber(r.getNumber());
            procurementPurchaseGoodEntity.setOtherRequirements(r.getOtherRequirements());
            procurementPurchaseGoodEntity.setPackageSpecification(r.getPackageSpecification());
            procurementPurchaseGoodEntity.setPackageUnit(r.getPackageUnit());
            procurementPurchaseGoodEntity.setPricePerUnit(r.getPricePerUnit());
            double p = r.getNumber() * r.getPricePerUnit();
            p = DecimalHelper.round(p, 2);
            procurementPurchaseGoodEntity.setTotalPrice(p);

            totalPrice += p;

            ProcurementRequestGoodEntity procurementRequestGoodEntity = procurementRequestGoodRepository.findOne(r.getProcurementRequestGoodEntity().getId());
            procurementPurchaseGoodEntity.setProcurementRequestGoodEntity(procurementRequestGoodEntity);

            pp.addGood(procurementPurchaseGoodEntity);
        }

        pp.setTotalPrice(totalPrice);

        return pp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getGeneratedDateTime() {
        return generatedDateTime;
    }

    public void setGeneratedDateTime(LocalDateTime generatedDateTime) {
        this.generatedDateTime = generatedDateTime;
    }

    public List<ProcurementPurchaseGoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<ProcurementPurchaseGoodEntity> goods) {
        this.goods = goods;
    }
}
