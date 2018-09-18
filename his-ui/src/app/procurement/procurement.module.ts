import {NgModule} from '@angular/core';

import {ProcurementRoutingModule} from './procurement-routing.module';
import {ProcurementSettingsComponent} from "./components/procurement-settings/procurement-settings.component";
import {VendorProductCategoryComponent} from "./components/procurement-settings/vendor-product-category/vendor-product-category.component";
import {CategoryListComponent} from "./components/procurement-settings/vendor-product-category/category-list/category-list.component";
import {CategoryDetailComponent} from "./components/procurement-settings/vendor-product-category/category-detail/category-detail.component";
import {VendorManagementComponent} from "./components/procurement-settings/vendor-management/vendor-management.component";
import {VendorCreateUpdateComponent} from "./components/procurement-settings/vendor-create-update/vendor-create-update.component";
import {ContactCreateUpdateComponent} from "./components/procurement-settings/vendor-create-update/contact-create-update/contact-create-update.component";
import {ProcurementWorkflowComponent} from "./components/procurement-settings/procurement-workflow/procurement-workflow.component";
import {ProcurementStatusComponent} from "./components/procurement-settings/procurement-status/procurement-status.component";
import {ProcurementRequestComponent} from "./components/procurement-request/procurement-request.component";
import {ProcurementRequestDetailComponent} from "./components/procurement-request/procurement-request-detail/procurement-request-detail.component";
import {ProcurementRequestDetailTableComponent} from "./components/procurement-request/procurement-request-detail/procurement-request-detail-table/procurement-request-detail-table.component";
import {ProcurementRequestCreateUpdateComponent} from "./components/procurement-request/procurement-request-create-update/procurement-request-create-update.component";
import {RequestGoodComponent} from "./components/procurement-request/procurement-request-create-update/request-good/request-good.component";
import {ProcurementPurchaseComponent} from "./components/procurement-purchase/procurement-purchase.component";
import {ProcurementPurchaseListComponent} from "./components/procurement-purchase/procurement-purchase-list/procurement-purchase-list.component";
import {ProcurementPurchaseDetailComponent} from "./components/procurement-purchase/procurement-purchase-detail/procurement-purchase-detail.component";
import {ProcurementPurchaseCreateUpdateComponent} from "./components/procurement-purchase/procurement-purchase-create-update/procurement-purchase-create-update.component";
import {ProcurementPurchaseGoodCreateUpdateComponent} from "./components/procurement-purchase/procurement-purchase-create-update/procurement-purchase-good-create-update/procurement-purchase-good-create-update.component";
import {ProcurementManagementComponent} from "./components/procurement-management/procurement-management.component";
import {ProcurementApprovalComponent} from "./components/procurement-approval/procurement-approval.component";
import {ProcurementTableListViewComponent} from "./components/procurement-approval/procurement-table-list-view/procurement-table-list-view.component";
import {ProcurementApprovalListComponent} from "./components/procurement-approval/procurement-approval-list/procurement-approval-list.component";
import {ProcurementApprovalDetailComponent} from "./components/procurement-approval/procurement-approval-detail/procurement-approval-detail.component";
import {ProcurementApprovalGuard} from "./guards/procurement-approval.guard";
import {ProcurementManagementGuard} from "./guards/procurement-management.guard";
import {VendorGuard} from "./guards/vendor.guard";
import {ProcurementService} from "./services/procurement.service";
import {ProcurementApprovalService} from "./services/procurement-approval.service";
import {ProcurementRequestService} from "./services/procurement-request.service";
import {ProcurementStatusService} from "./services/procurement-status.service";
import {VendorService} from "./services/vendor.service";
import {VendorCategoryService} from "./services/vendor-category.service";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    ProcurementRoutingModule
  ],
  declarations: [
    ProcurementSettingsComponent,
    VendorProductCategoryComponent,
    CategoryListComponent,
    CategoryDetailComponent,
    VendorManagementComponent,
    VendorCreateUpdateComponent,
    ContactCreateUpdateComponent,
    ProcurementWorkflowComponent,
    ProcurementStatusComponent,
    ProcurementRequestComponent,
    ProcurementRequestDetailComponent,
    ProcurementRequestDetailTableComponent,
    ProcurementRequestCreateUpdateComponent,
    RequestGoodComponent,
    ProcurementPurchaseComponent,
    ProcurementPurchaseListComponent,
    ProcurementPurchaseDetailComponent,
    ProcurementPurchaseCreateUpdateComponent,
    ProcurementPurchaseGoodCreateUpdateComponent,
    ProcurementManagementComponent,
    ProcurementApprovalComponent,
    ProcurementTableListViewComponent,
    ProcurementApprovalListComponent,
    ProcurementApprovalDetailComponent,
  ],
  providers:[
    ProcurementApprovalGuard,
    ProcurementManagementGuard,
    VendorGuard,
    ProcurementService,
    ProcurementApprovalService,
    ProcurementRequestService,
    ProcurementStatusService,
    VendorService,
    VendorCategoryService
  ]

})
export class ProcurementModule { }
