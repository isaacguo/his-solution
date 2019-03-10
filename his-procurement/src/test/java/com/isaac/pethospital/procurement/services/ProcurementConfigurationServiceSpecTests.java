package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.constants.ConfigurationConstants;
import com.isaac.pethospital.procurement.entities.ProcurementConfigurationEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementConfigurationRepository;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ProcurementConfigurationServiceSpecTests {


    ProcurementConfigurationRepository procurementConfigurationRepository;
    ProcurementConfigurationService procurementConfigurationService;


    @Before
    public void before() {
        this.procurementConfigurationRepository = mock(ProcurementConfigurationRepository.class);
        this.procurementConfigurationService = spy(new ProcurementConfigurationServiceImpl(this.procurementConfigurationRepository));
    }

    @Test
    public void whenGetNextOrderNumberThenGetAnOrderNumberWithPaddingZeroOnTheLeft()
    {
        initForGetNextOrderNumber();

        //when
        String orderNumber=this.procurementConfigurationService.getOrderNumber();
        //then
        verify(this.procurementConfigurationRepository,times(1)).findByConfKey("OrderNumber");
        verify(this.procurementConfigurationRepository,times(1)).findByConfKey("OrderNumberLength");
        assertThat(orderNumber).isEqualToIgnoringCase("00000002");
    }

    private void initForGetNextOrderNumber() {
        ProcurementConfigurationEntity pce1=new ProcurementConfigurationEntity();
        pce1.setConfKey(ConfigurationConstants.OrderNumber);
        pce1.setConfValue("2");

        ProcurementConfigurationEntity pce2=new ProcurementConfigurationEntity();
        pce2.setConfKey(ConfigurationConstants.OrderNumberLength);
        pce2.setConfValue("8");

        doReturn(pce1).when(this.procurementConfigurationRepository).findByConfKey(ConfigurationConstants.OrderNumber);
        doReturn(pce2).when(this.procurementConfigurationRepository).findByConfKey(ConfigurationConstants.OrderNumberLength);
    }

    @Test
    public void whenGetNextOrderNumberThenOrderNumberIsAddedByOneAutomatically()
    {
        initForGetNextOrderNumber();

        //when
        this.procurementConfigurationService.getOrderNumber();
        String orderNumber=this.procurementConfigurationService.getOrderNumber();
        //then
        verify(procurementConfigurationRepository,times(2)).save(any(ProcurementConfigurationEntity.class));
        assertThat(orderNumber).isEqualToIgnoringCase("00000003");
    }
}
