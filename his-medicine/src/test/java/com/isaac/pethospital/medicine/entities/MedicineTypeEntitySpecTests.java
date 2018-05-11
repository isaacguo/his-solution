package com.isaac.pethospital.medicine.entities;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class MedicineTypeEntitySpecTests {

    MedicineTypeEntity medicineTypeEntity;

    @Before
    public void init() {

        this.medicineTypeEntity = new MedicineTypeEntity();
        this.medicineTypeEntity.setId(1L);
        this.medicineTypeEntity.setName("悬混液");
    }

    @Test
    public void givenMedicineTypeEntityHasFieldId() {
        assertThat(medicineTypeEntity, hasProperty("id", is(1L)));
    }

    @Test
    public void givenMedicineTypeEntityHasFieldName() {
        assertThat(medicineTypeEntity, hasProperty("name", is("悬混液")));
    }
}

