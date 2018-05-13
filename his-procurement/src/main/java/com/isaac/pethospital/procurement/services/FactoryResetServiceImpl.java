package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.procurement.constants.ConfigurationConstants;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;
    private final ProcurementStatusRepository procurementStatusRepository;
    private final ProcurementConfigurationRepository procurementConfigurationRepository;
    private final ProcurementApprovalStageRepository procurementApprovalStageRepository;
    private final VendorRepository vendorRepository;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService, ProcurementStatusRepository procurementStatusRepository, ProcurementConfigurationRepository procurementConfigurationRepository, ProcurementApprovalStageRepository procurementApprovalStageRepository, VendorRepository vendorRepository, VendorCategoryRepository vendorCategoryRepository) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.procurementStatusRepository = procurementStatusRepository;
        this.procurementConfigurationRepository = procurementConfigurationRepository;
        this.procurementApprovalStageRepository = procurementApprovalStageRepository;
        this.vendorRepository = vendorRepository;
        this.vendorCategoryRepository = vendorCategoryRepository;
    }

    private final VendorCategoryRepository vendorCategoryRepository;

    @Transactional
    @Override
    public void reset() {

        this.procurementStatusRepository.deleteAll();
        this.procurementConfigurationRepository.deleteAll();
        this.procurementApprovalStageRepository.deleteAll();
        this.vendorRepository.deleteAll();

        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();
        authorizationService.setDomainName("Procurement");
        authorizationTopicService.addAuthorizationTopicAndOperations("ProcurementApproval","Admin");
        authorizationTopicService.addAuthorizationTopicAndOperations("Vendor","Admin");

    }

    @Override
    public void insertData() {

        initProcurementStatus();
        initConfiguration();
        initApproval();
        initVendor();

    }

    private void initVendor() {


        VendorProductEntity vpe1 = new VendorProductEntity();
        vpe1.setOrderNumber("RF VT Set (Basic)");
        vpe1.setProductEnglishName("VETTEST, N.AMERICA,RECERTIFIED");
        vpe1.setProductChineseName("兽医专用生化分析仪(简配)");
        vpe1.setPackageSpecification("套");
        vpe1.setPackageUnit("套");
        vpe1.setPricePerUnit(19900.00);
        vpe1.setCurrency("RMB");
        vpe1.setProductSet(true);

        VendorProductEntity vpe2 = new VendorProductEntity();
        vpe2.setOrderNumber("RF-20380-01");
        vpe2.setProductEnglishName("VETTEST, N.AMERICA,RECERTIFIED");
        vpe2.setProductChineseName("生化分析仪主机（展示机）");
        vpe2.setPackageSpecification("台");
        vpe2.setPackageUnit("1");

        VendorProductEntity vpe3 = new VendorProductEntity();
        vpe3.setOrderNumber("98-19792-00");
        vpe3.setProductEnglishName("VETTEST SOFTWARE UPGRADE PACKET-INVENTOR");
        vpe3.setProductChineseName("VETTEST软件升级包");
        vpe3.setPackageSpecification("个");
        vpe3.setPackageUnit("1");


        vpe1.addChild(vpe2);
        vpe1.addChild(vpe3);


        //VendorProductEntity vpex = vendorProductRepository.save(vpe1);


        VendorEntity ve = new VendorEntity();
        ve.setName("IDEXX");
        vendorRepository.save(ve);

        VendorEntity ve1=new VendorEntity();
        ve1.setName("得力");
        vendorRepository.save(ve1);


        VendorCategoryEntity vendorCategoryEntity1 = new VendorCategoryEntity();
        vendorCategoryEntity1.setName("医疗用品及材料");
        //vendorCategoryEntity1.addChildByName("医疗用品");
        //vendorCategoryEntity1.addChildByName("材料");
        VendorCategoryEntity vendorCategoryEntity2 = new VendorCategoryEntity();
        vendorCategoryEntity2.setName("医疗影像");
        //vendorCategoryEntity2.addChildByName("医疗设备");
        VendorCategoryEntity vendorCategoryEntity3 = new VendorCategoryEntity();

        vendorCategoryEntity3.setName("办公采购");
        //vendorCategoryEntity3.addChildByName("办公用品");

        vendorCategoryRepository.save(vendorCategoryEntity1);

        vendorCategoryEntity2.addVendor(ve);

        vendorCategoryRepository.save(vendorCategoryEntity2);

        vendorRepository.save(ve);

        vendorCategoryEntity3.addVendor(ve1);
        vendorCategoryRepository.save(vendorCategoryEntity3);
        vendorRepository.save(ve1);



                /*
                VendorCategoryEntity vendorProductCategoryEntity1 = new VendorCategoryEntity();
                vendorProductCategoryEntity1.setName("VetLab 实验室检验仪器");
                vendorProductCategoryEntity1.setVendor(ve);
                //vendorProductCategoryEntity1.addProduct(vpe1);
                vendorCategoryRepository.save(vendorProductCategoryEntity1);


                vpe1.setCategory(vendorProductCategoryEntity1);
                vendorProductRepository.save(vpe1);
                */
    }
    private void initApproval() {
        ProcurementApprovalStageEntity procurementApprovalStageEntity1 = new ProcurementApprovalStageEntity();
        procurementApprovalStageEntity1.setStage("申请人");

        ProcurementApprovalStageEntity procurementApprovalStageEntity2 = new ProcurementApprovalStageEntity();
        procurementApprovalStageEntity2.setStage("部门经理");

        ProcurementApprovalStageEntity procurementApprovalStageEntity3 = new ProcurementApprovalStageEntity();
        procurementApprovalStageEntity3.setStage("总经理");

        procurementApprovalStageEntity1.setNextStage(procurementApprovalStageEntity2);
        procurementApprovalStageEntity2.setNextStage(procurementApprovalStageEntity3);

        procurementApprovalStageRepository.save(procurementApprovalStageEntity1);
    }

    private void initConfiguration() {
        ProcurementConfigurationEntity pce1 = new ProcurementConfigurationEntity();
        pce1.setConfKey(ConfigurationConstants.OrderNumber);
        pce1.setConfValue("1");
        ProcurementConfigurationEntity pce2 = new ProcurementConfigurationEntity();
        pce2.setConfKey(ConfigurationConstants.OrderNumberLength);
        pce2.setConfValue("8");

        procurementConfigurationRepository.save(pce1);
        procurementConfigurationRepository.save(pce2);
    }

    private void initProcurementStatus() {
        ProcurementStatusEntity status1 = new ProcurementStatusEntity();
        status1.setStatus("申请已提交");
        ProcurementStatusEntity status2 = new ProcurementStatusEntity();
        status2.setStatus("申请批复中");
        status2.setLastStatusResult(true);
        ProcurementStatusEntity status3 = new ProcurementStatusEntity();
        status3.setStatus("申请已通过");
        status3.setLastStatusResult(true);
        ProcurementStatusEntity status4 = new ProcurementStatusEntity();
        status4.setStatus("申请已退回");
        status4.setLastStatusResult(false);
        ProcurementStatusEntity status5 = new ProcurementStatusEntity();
        status5.setStatus("采购进行中");
        status5.setLastStatusResult(true);
        ProcurementStatusEntity status6 = new ProcurementStatusEntity();
        status6.setStatus("采购逾期");
        status6.setLastStatusResult(false);
        ProcurementStatusEntity status7 = new ProcurementStatusEntity();
        status7.setStatus("采购已到货");
        status7.setLastStatusResult(true);
        ProcurementStatusEntity status8 = new ProcurementStatusEntity();
        status8.setStatus("采购已退货");
        status8.setLastStatusResult(false);
        ProcurementStatusEntity status9 = new ProcurementStatusEntity();
        status9.setStatus("采购已入库");
        status9.setLastStatusResult(true);

        status1.addNext(status2);

        status2.addNext(status3);
        status2.addNext(status4);

        status3.addNext(status5);
        status3.addNext(status6);

        status5.addNext(status7);
        status5.addNext(status8);

        status7.addNext(status9);


        procurementStatusRepository.save(status1);
    }
}
