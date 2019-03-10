package com.isaac.pethospital.medicine.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MedicineEntity {

    @ManyToOne
    MedicineTypeEntity medicineType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hanYuPinYinName;
    private String barCode;     // 货品编码
    private String packageUnit; //包装规格单位  瓶，盒
    private Long packageCount; //包装规格数量
    private String medicineSpecificationUnit; //药品规格单位
    private String medicineSpecification; //药品规格 药品规格就是药品最小包装或最小单体的一个量度值
    private String dosagePerDay;  //每日药品剂量
    private LocalDateTime productionDate;   //
    private LocalDateTime expirationDate;
    private Long price;           //单价
    private Long stock;

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getHanYuPinYinName() {
        return hanYuPinYinName;
    }

    public void setHanYuPinYinName(String hanYuPinYinName) {
        this.hanYuPinYinName = hanYuPinYinName;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public Long getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(Long packageCount) {
        this.packageCount = packageCount;
    }

    public String getMedicineSpecificationUnit() {
        return medicineSpecificationUnit;
    }

    public void setMedicineSpecificationUnit(String medicineSpecificationUnit) {
        this.medicineSpecificationUnit = medicineSpecificationUnit;
    }

    public String getMedicineSpecification() {
        return medicineSpecification;
    }

    public void setMedicineSpecification(String medicineSpecification) {
        this.medicineSpecification = medicineSpecification;
    }

    public String getDosagePerDay() {
        return dosagePerDay;
    }

    public void setDosagePerDay(String dosagePerDay) {
        this.dosagePerDay = dosagePerDay;
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

    public MedicineTypeEntity getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineTypeEntity medicineType) {
        this.medicineType = medicineType;
    }
}
