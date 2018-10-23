import {NgModule} from '@angular/core';

import {InventoryRoutingModule} from './inventory-routing.module';
import {SharedModule} from "../shared/shared.module";
import { ImportManagementContainerComponent } from './containers/import-management-container/import-management-container.component';
import { ImportManagementComponent } from './components/import-management/import-management.component';
import { ExportManagementContainerComponent } from './containers/export-management-container/export-management-container.component';
import { ExportManagementComponent } from './components/export-management/export-management.component';
import { InventorySettingsContainerComponent } from './containers/inventory-settings-container/inventory-settings-container.component';
import { InventorySettingsComponent } from './components/inventory-settings/inventory-settings.component';
import { InventorySettingsItemManagementContainerComponent } from './containers/inventory-settings-item-management-container/inventory-settings-item-management-container.component';
import { InventorySettingsItemManagementComponent } from './components/inventory-settings-item-management/inventory-settings-item-management.component';
import { InventoryQueryContainerComponent } from './containers/inventory-query-container/inventory-query-container.component';
import { InventoryCategoryTreeComponent } from './components/inventory-category-tree/inventory-category-tree.component';
import { ImportReceiptContainerComponent } from './containers/import-receipt-container/import-receipt-container.component';
import { ExportReceiptContainerComponent } from './containers/export-receipt-container/export-receipt-container.component';
import { InventoryQueryCategoryDetailContainerComponent } from './containers/inventory-query-category-detail-container/inventory-query-category-detail-container.component';
import { InventoryQueryCategoryDetailComponent } from './components/inventory-query-category-detail/inventory-query-category-detail.component';

@NgModule({
  imports: [
    SharedModule,
    InventoryRoutingModule
  ],
  declarations: [ImportManagementContainerComponent, ImportManagementComponent, ExportManagementContainerComponent, ExportManagementComponent, InventorySettingsContainerComponent, InventorySettingsComponent, InventorySettingsItemManagementContainerComponent, InventorySettingsItemManagementComponent, InventoryQueryContainerComponent, InventoryCategoryTreeComponent, ImportReceiptContainerComponent, ExportReceiptContainerComponent, InventoryQueryCategoryDetailContainerComponent, InventoryQueryCategoryDetailComponent]
})
export class InventoryModule { }
