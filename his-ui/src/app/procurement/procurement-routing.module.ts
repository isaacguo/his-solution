import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProcurementManagementComponent} from "./components/procurement-management/procurement-management.component";
import {ProcurementApprovalComponent} from "./components/procurement-approval/procurement-approval.component";
import {ProcurementApprovalGuard} from "../core/guards/procurement/procurement-approval.guard";
import {ProcurementApprovalListComponent} from "./components/procurement-approval/procurement-approval-list/procurement-approval-list.component";
import {ProcurementPurchaseComponent} from "./components/procurement-purchase/procurement-purchase.component";
import {ProcurementPurchaseListComponent} from "./components/procurement-purchase/procurement-purchase-list/procurement-purchase-list.component";
import {ProcurementRequestCreateUpdateComponent} from "./components/procurement-request/procurement-request-create-update/procurement-request-create-update.component";
import {ProcurementSettingsComponent} from "./components/procurement-settings/procurement-settings.component";
import {VendorCreateUpdateComponent} from "./components/procurement-settings/vendor-create-update/vendor-create-update.component";
import {VendorProductCategoryComponent} from "./components/procurement-settings/vendor-product-category/vendor-product-category.component";
import {VendorGuard} from "./guards/vendor.guard";
import {ProcurementStatusComponent} from "./components/procurement-settings/procurement-status/procurement-status.component";
import {ProcurementWorkflowComponent} from "./components/procurement-settings/procurement-workflow/procurement-workflow.component";

const routes: Routes = [
  {
    path: '',
    component: ProcurementManagementComponent
  },
  {
    path: 'procurement-approval',
    component: ProcurementApprovalComponent,
    canActivate: [ProcurementApprovalGuard],
    children: [
      {
        path: 'list',
        component: ProcurementApprovalListComponent,
      },
      {
        path: '**',
        redirectTo: 'list',
      }
    ]
  },
  {
    path: 'procurement-purchase',
    component: ProcurementPurchaseComponent,
    children: [
      {
        path: 'list',
        component: ProcurementPurchaseListComponent
      },
      {
        path: ':operation',
        component: ProcurementRequestCreateUpdateComponent,
      },
      /*
      {
        path:':operation',
        component:ProcurementPurchaseCreateUpdateComponent
      },
      {
        path: ':operation/:updateId',
        component: ProcurementPurchaseCreateUpdateComponent,
      },
      */
      {
        path: '**',
        redirectTo: 'list'
      }
    ]
  },
  {
    path: 'procurement-settings',
    component: ProcurementSettingsComponent,
    children: [
      {
        path: 'vendors/:operation',
        component: VendorCreateUpdateComponent
      },
      {
        path: 'vendors/:operation/:updateId',
        component: VendorCreateUpdateComponent
      },
      {
        path: 'vendors',
        component: VendorProductCategoryComponent,
        canActivate: [VendorGuard],

      },
      {
        path: 'procurement-status',
        component: ProcurementStatusComponent
      },
      {
        path: 'procurement-workflow',
        component: ProcurementWorkflowComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcurementRoutingModule { }
