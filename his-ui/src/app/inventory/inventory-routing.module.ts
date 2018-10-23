import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ImportManagementContainerComponent} from "./containers/import-management-container/import-management-container.component";
import {ExportManagementContainerComponent} from "./containers/export-management-container/export-management-container.component";
import {InventorySettingsContainerComponent} from "./containers/inventory-settings-container/inventory-settings-container.component";
import {InventorySettingsItemManagementContainerComponent} from "./containers/inventory-settings-item-management-container/inventory-settings-item-management-container.component";
import {InventoryQueryContainerComponent} from "./containers/inventory-query-container/inventory-query-container.component";
import {ImportReceiptContainerComponent} from "./containers/import-receipt-container/import-receipt-container.component";
import {ExportReceiptContainerComponent} from './containers/export-receipt-container/export-receipt-container.component';
import {InventoryQueryCategoryDetailContainerComponent} from "./containers/inventory-query-category-detail-container/inventory-query-category-detail-container.component";

const routes: Routes = [
  {
    path: 'import-management',
    component: ImportManagementContainerComponent,
    children: [
      {
        path: 'receipts/:receiptId',
        component: ImportReceiptContainerComponent
      }
    ]
  },
  {
    path: 'export-management',
    component: ExportManagementContainerComponent,
    children: [
      {
        path: 'receipts/:receiptId',
        component: ExportReceiptContainerComponent
      }
    ]
  },
  {
    path: 'query',
    component: InventoryQueryContainerComponent,
    children: [
      {
        path: 'category/:categoryId',
        component: InventoryQueryCategoryDetailContainerComponent
      }
    ]
  },
  {
    path: 'settings',
    component: InventorySettingsContainerComponent,
    children: [
      {
        path: 'item-management',
        component: InventorySettingsItemManagementContainerComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InventoryRoutingModule {
}
