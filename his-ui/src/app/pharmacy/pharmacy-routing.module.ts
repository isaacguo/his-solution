import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PharmacyDispensingContainerComponent} from "./containers/pharmacy-dispensing-container/pharmacy-dispensing-container.component";
import {DispensingDetailContainerComponent} from "./containers/dispensing-detail-container/dispensing-detail-container.component";

const routes: Routes = [
  {
    path: 'dispensing',
    component: PharmacyDispensingContainerComponent,
    children:[
      {
        path: 'receipts/:receiptId',
        component:DispensingDetailContainerComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PharmacyRoutingModule { }
