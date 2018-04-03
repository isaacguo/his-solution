package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.common.math.DecimalHelper;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestGoodRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestRepository;
import com.isaac.pethospital.procurement.services.ProcurementRequestService;
import com.isaac.pethospital.procurement.services.ProcurementService;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ProcurementPurchaseOperationRequest {

    private Long id;
    LocalDateTime generatedDateTime; //表单生成时间

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    Long purchaseId;
    List<ProcurementPurchaseGoodEntity> goods = new LinkedList<>();

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
