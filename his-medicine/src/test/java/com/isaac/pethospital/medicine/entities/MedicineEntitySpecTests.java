package com.isaac.pethospital.medicine.entities;

import org.junit.Before;
import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class MedicineEntitySpecTests {

    MedicineEntity medicineEntity;
    MedicineTypeEntity medicineTypeEntity;
    @Before
    public void init() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.medicineEntity = new MedicineEntity();
        this.medicineEntity.setId(1L);
        this.medicineEntity.setName("阿司匹林");
        this.medicineEntity.setPackageUnit("瓶/箱");
        this.medicineEntity.setPackageCount(6L);
        this.medicineEntity.setMedicineSpecificationUnit("ml/瓶");
        this.medicineEntity.setMedicineSpecification("40");

        this.medicineTypeEntity=new MedicineTypeEntity();
        this.medicineEntity.setMedicineType(this.medicineTypeEntity);

    }
    @Test
    public void givenMedicineEntityHasFieldId() {
        assertThat(medicineEntity, hasProperty("id", is(1L)));
    }

    @Test
    public void givenMedicineEntityHasFieldName() {
        assertThat(medicineEntity, hasProperty("name", is("阿司匹林")));
    }

    @Test
    public void givenMedicineEntityHasFieldMedicineType() {
        assertThat(medicineEntity, hasProperty("medicineType", is(this.medicineTypeEntity)));
    }


}
