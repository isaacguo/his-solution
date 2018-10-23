import {NgModule} from '@angular/core';

import {PharmacyRoutingModule} from './pharmacy-routing.module';
import {SharedModule} from "../shared/shared.module";
import { PharmacyDispensingContainerComponent } from './containers/pharmacy-dispensing-container/pharmacy-dispensing-container.component';
import { PharmacyDispensingComponent } from './components/pharmacy-dispensing/pharmacy-dispensing.component';
import { DispensingDetailContainerComponent } from './containers/dispensing-detail-container/dispensing-detail-container.component';
import { PharmacyDispensingDetailComponent } from './components/pharmacy-dispensing-detail/pharmacy-dispensing-detail.component';
import { MedicineTableComponent } from './components/medicine-table/medicine-table.component';
import { BasicInfoComponent } from './components/basic-info/basic-info.component';

@NgModule({
  imports: [
    SharedModule,
    PharmacyRoutingModule
  ],
  declarations: [PharmacyDispensingContainerComponent, PharmacyDispensingComponent, DispensingDetailContainerComponent, PharmacyDispensingDetailComponent, MedicineTableComponent, BasicInfoComponent]
})
export class PharmacyModule { }
