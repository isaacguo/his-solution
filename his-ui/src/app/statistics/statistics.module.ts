import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatisticsRoutingModule } from './statistics-routing.module';
import { TreatmentContainerComponent } from './containers/treatment-container/treatment-container.component';
import { TreatmentComponent } from './components/treatment/treatment.component';
import { FinanceContainerComponent } from './containers/finance-container/finance-container.component';
import { FinanceComponent } from './components/finance/finance.component';
import { MedicineContainerComponent } from './containers/medicine-container/medicine-container.component';
import { MedicineComponent } from './components/medicine/medicine.component';
import { ProcurementContainerComponent } from './containers/procurement-container/procurement-container.component';
import { ProcurementComponent } from './components/procurement/procurement.component';
import { MedicalTestContainerComponent } from './containers/medical-test-container/medical-test-container.component';
import { MedicalTestComponent } from './components/medical-test/medical-test.component';

@NgModule({
  imports: [
    CommonModule,
    StatisticsRoutingModule
  ],
  declarations: [TreatmentContainerComponent, TreatmentComponent, FinanceContainerComponent, FinanceComponent, MedicineContainerComponent, MedicineComponent, ProcurementContainerComponent, ProcurementComponent, MedicalTestContainerComponent, MedicalTestComponent]
})
export class StatisticsModule { }
