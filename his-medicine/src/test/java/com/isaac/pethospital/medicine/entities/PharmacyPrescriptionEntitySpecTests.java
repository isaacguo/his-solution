package com.isaac.pethospital.medicine.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class PharmacyPrescriptionEntitySpecTests {

    PharmacyPrescriptionEntity pharmacyPrescriptionEntity;

    @Before
    public void init() {

        this.pharmacyPrescriptionEntity = new PharmacyPrescriptionEntity();
    }


    @Test
    public void givenMedicineEntityHasFieldId() {
        LinkedList<PharmacyPrescriptionItemEntity> list=new LinkedList<>();
        assertThat(pharmacyPrescriptionEntity, hasProperty("items",isA(list.getClass())));
    }
}
