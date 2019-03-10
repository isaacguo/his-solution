import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {ProcurementRoutingModule} from './procurement-routing.module';
import {ProcurementManagementContainerComponent} from './containers/procurement-management-container/procurement-management-container.component';
import {ProcurementSettingsContainerComponent} from './containers/procurement-settings-container/procurement-settings-container.component';
import {ProcurementSettingsVendorsContainerComponent} from './containers/procurement-settings-vendors-container/procurement-settings-vendors-container.component';


import {ProcurementManagementComponent} from './components/procurement-management/procurement-management.component';
import {ProcurementSettingsComponent} from './components/procurement-settings/procurement-settings.component';
import {VendorManagementComponent} from './components/procurement-settings/vendor-management/vendor-management.component';
import {VendorCreateUpdateComponent} from './components/procurement-settings/vendor-create-update/vendor-create-update.component';
import {ContactCreateUpdateComponent} from './components/procurement-settings/vendor-create-update/contact-create-update/contact-create-update.component';
import {ProcurementStatusComponent} from './components/procurement-settings/procurement-status/procurement-status.component';
import {ProcurementRequestComponent} from './components/procurement-request/procurement-request.component';
import {ProcurementApprovalComponent} from './components/procurement-approval/procurement-approval.component';
import {ProcurementWorkflowComponent} from './components/procurement-settings/procurement-workflow/procurement-workflow.component';
import {ProcurementRequestCreateUpdateComponent} from './components/procurement-request/procurement-request-create-update/procurement-request-create-update.component';
import {ProcurementRequestDetailComponent} from './components/procurement-request/procurement-request-detail/procurement-request-detail.component';
import {RequestGoodComponent} from './components/procurement-request/procurement-request-create-update/request-good/request-good.component';
import {ProcurementApprovalListComponent} from './components/procurement-approval/procurement-approval-list/procurement-approval-list.component';
import {ProcurementApprovalDetailComponent} from './components/procurement-approval/procurement-approval-detail/procurement-approval-detail.component';
import {ProcurementTableListViewComponent} from './components/procurement-approval/procurement-table-list-view/procurement-table-list-view.component';
import {ProcurementPurchaseComponent} from './components/procurement-purchase/procurement-purchase.component';
import {ProcurementPurchaseListComponent} from './components/procurement-purchase/procurement-purchase-list/procurement-purchase-list.component';
import {ProcurementPurchaseCreateUpdateComponent} from './components/procurement-purchase/procurement-purchase-create-update/procurement-purchase-create-update.component';
import {ProcurementPurchaseGoodCreateUpdateComponent} from './components/procurement-purchase/procurement-purchase-create-update/procurement-purchase-good-create-update/procurement-purchase-good-create-update.component';
import {ProcurementPurchaseDetailComponent} from './components/procurement-purchase/procurement-purchase-detail/procurement-purchase-detail.component';
import {ProcurementRequestDetailTableComponent} from './components/procurement-request/procurement-request-detail/procurement-request-detail-table/procurement-request-detail-table.component';
import {VendorProductCategoryComponent} from './components/procurement-settings/vendor-product-category/vendor-product-category.component';
import {CategoryListComponent} from './components/procurement-settings/vendor-product-category/category-list/category-list.component';
import {CategoryDetailComponent} from './components/procurement-settings/vendor-product-category/category-detail/category-detail.component';
import {SharedModule} from "../shared/shared.module";


@NgModule({
  imports: [
    SharedModule,
    ProcurementRoutingModule
  ],
  declarations: [ProcurementManagementContainerComponent,
    ProcurementManagementComponent,
    ProcurementSettingsContainerComponent,
    ProcurementSettingsComponent,
    ProcurementSettingsVendorsContainerComponent,


    VendorManagementComponent,
    VendorCreateUpdateComponent,
    ContactCreateUpdateComponent,
    ProcurementStatusComponent,
    ProcurementRequestComponent,
    ProcurementApprovalComponent,
    ProcurementWorkflowComponent,
    ProcurementRequestCreateUpdateComponent,
    ProcurementRequestDetailComponent,
    RequestGoodComponent,
    ProcurementApprovalListComponent,
    ProcurementApprovalDetailComponent,
    ProcurementTableListViewComponent,
    ProcurementPurchaseComponent,
    ProcurementPurchaseListComponent,
    ProcurementPurchaseCreateUpdateComponent,
    ProcurementPurchaseGoodCreateUpdateComponent,
    ProcurementPurchaseDetailComponent,
    ProcurementRequestDetailTableComponent,
    VendorProductCategoryComponent,
    CategoryListComponent,
    CategoryDetailComponent,


  ]
})
export class ProcurementModule {
}
