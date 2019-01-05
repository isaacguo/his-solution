import {NgModule} from '@angular/core';

import {InventoryRoutingModule} from './inventory-routing.module';
import {SharedModule} from "../shared/shared.module";
import {ImportManagementContainerComponent} from './containers/import-management-container/import-management-container.component';
import {ImportManagementComponent} from './components/import-management/import-management.component';
import {ExportManagementContainerComponent} from './containers/export-management-container/export-management-container.component';
import {ExportManagementComponent} from './components/export-management/export-management.component';
import {InventorySettingsContainerComponent} from './containers/inventory-settings-container/inventory-settings-container.component';
import {InventorySettingsComponent} from './components/inventory-settings/inventory-settings.component';
import {InventorySettingsItemManagementContainerComponent} from './containers/inventory-settings-item-management-container/inventory-settings-item-management-container.component';
import {InventoryQueryContainerComponent} from './containers/inventory-query-container/inventory-query-container.component';
import {ImportReceiptContainerComponent} from './containers/import-receipt-container/import-receipt-container.component';
import {ExportReceiptContainerComponent} from './containers/export-receipt-container/export-receipt-container.component';
import {InventoryQueryCategoryDetailContainerComponent} from './containers/inventory-query-category-detail-container/inventory-query-category-detail-container.component';

import {ImportManagementListComponent} from './components/import-management/import-management-list/import-management-list.component';
import {ImportManagementDetailComponent} from './components/import-management/import-management-list/import-management-detail/import-management-detail.component';
import {InventoryOperationToolBarComponent} from './components/inventory-operation-tool-bar/inventory-operation-tool-bar.component';
import {InventorySettingsWarehourseComponent} from './components/inventory-settings/inventory-settings-warehourse/inventory-settings-warehourse.component';
import {InventoryQueryListComponent} from './components/inventory-query/inventory-query-list/inventory-query-list.component';
import {InventoryItemCreateUpdateComponent} from './components/inventory-item-create-update/inventory-item-create-update.component';
import {ImportSheetCreateUpdateComponent} from './components/import-sheet-create-update/import-sheet-create-update.component';
import {ExportSheetCreateUpdateComponent} from './components/export-sheet-create-update/export-sheet-create-update.component';
import {InventoryQueryComponent} from './components/inventory-query/inventory-query.component';
import {InventorySettingsItemManagementComponent} from './components/inventory-settings/inventory-settings-item-management/inventory-settings-item-management.component';
import {InventorySettingsItemManagementDetailComponent} from './components/inventory-settings/inventory-settings-item-management/inventory-settings-item-management-detail/inventory-settings-item-management-detail.component';
import {ExportManagementListComponent} from './components/export-management/export-management-list/export-management-list.component';
import {ExportManagementDetailComponent} from './components/export-management/export-management-list/export-management-detail/export-management-detail.component';

@NgModule({
  imports: [
    SharedModule,
    InventoryRoutingModule
  ],
  declarations: [ImportManagementContainerComponent,
    ImportManagementComponent,
    ExportManagementContainerComponent,
    ExportManagementComponent,
    InventorySettingsContainerComponent,
    InventorySettingsComponent,
    InventorySettingsItemManagementContainerComponent,
    InventorySettingsItemManagementComponent,
    InventoryQueryContainerComponent,
    ImportReceiptContainerComponent,
    ExportReceiptContainerComponent,
    InventoryQueryCategoryDetailContainerComponent,

    ImportManagementListComponent,
    ImportManagementDetailComponent,
    InventoryOperationToolBarComponent,
    InventorySettingsWarehourseComponent,
    InventoryQueryListComponent,
    InventoryItemCreateUpdateComponent,
    ImportSheetCreateUpdateComponent,
    ExportSheetCreateUpdateComponent,
    InventoryQueryComponent,
    InventorySettingsItemManagementComponent,
    InventorySettingsItemManagementDetailComponent,
    ExportManagementListComponent,
    ExportManagementDetailComponent,
    ]
})
export class InventoryModule {
}
