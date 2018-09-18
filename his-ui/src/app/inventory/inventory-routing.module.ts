import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {InventoryComponent} from "./components/inventory.component";
import {ImportManagementComponent} from "./components/import-management/import-management.component";
import {ImportSheetCreateUpdateComponent} from "./components/import-sheet-create-update/import-sheet-create-update.component";
import {ExportManagementComponent} from "./components/export-management/export-management.component";
import {ExportSheetCreateUpdateComponent} from "./components/export-sheet-create-update/export-sheet-create-update.component";
import {InventoryQueryComponent} from "./components/inventory-query/inventory-query.component";
import {InventoryItemCreateUpdateComponent} from "./components/inventory-item-create-update/inventory-item-create-update.component";
import {InventorySettingsComponent} from "./components/inventory-settings/inventory-settings.component";
import {InventorySettingsWarehourseComponent} from "./components/inventory-settings/inventory-settings-warehourse/inventory-settings-warehourse.component";
import {InventorySettingsItemManagementComponent} from "./components/inventory-settings/inventory-settings-item-management/inventory-settings-item-management.component";

const routes: Routes = [
  {
    path: 'inventory',
    component: InventoryComponent
  },
  {
    path: 'inventory-import-management',
    component: ImportManagementComponent
  },
  {
    path: 'inventory-import/:operation',
    component: ImportSheetCreateUpdateComponent
  },
  {
    path: 'inventory-export-management',
    component: ExportManagementComponent
  },
  {
    path: 'inventory-export/:operation',
    component: ExportSheetCreateUpdateComponent
  },
  {
    path: 'inventory-query',
    component: InventoryQueryComponent
  },
  {
    path: 'inventory-item/:operation/:updateId',
    component: InventoryItemCreateUpdateComponent
  },
  {
    path: 'inventory-settings',
    component: InventorySettingsComponent,
    children: [
      {
        path: 'warehouses',
        component: InventorySettingsWarehourseComponent
      },
      {
        path:'item-management',
        component:InventorySettingsItemManagementComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class InventoryRoutingModule { }
