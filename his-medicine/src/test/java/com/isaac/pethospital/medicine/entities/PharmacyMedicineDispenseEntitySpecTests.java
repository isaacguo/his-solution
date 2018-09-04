package com.isaac.pethospital.medicine.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class PharmacyMedicineDispenseEntitySpecTests {

    PharmacyMedicineDispenseEntity pharmacyMedicineDispenseEntity;

    @Before
    public void init() {

        this.pharmacyMedicineDispenseEntity = new PharmacyMedicineDispenseEntity();
    }


    @Test
    public void givenMedicineEntityHasFieldId() {
        LinkedList<PharmacyMedicineDispenseItemEntity> list=new LinkedList<>();
        assertThat(pharmacyMedicineDispenseEntity, hasProperty("items",isA(list.getClass())));
    }
}
