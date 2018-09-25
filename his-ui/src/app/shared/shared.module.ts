import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {QueryBarComponent} from "./query-bar/query-bar.component";
import {EditorComponent} from "./editor/editor.component";
import {FieldEditComponent} from "./field-edit/field-edit.component";
import {TabsComponent} from "../ui-controls/tabs/tabs.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {NgxPaginationModule} from "ngx-pagination";
import {UiSwitchModule} from "ngx-ui-switch";
import {MyDatePickerModule} from "mydatepicker";
import {AngularSplitModule} from "angular-split";
import {TreeModule} from "angular-tree-component";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {HttpModule} from "@angular/http";
import {MedicalTestSettingsReportComponent} from "./components/medical-test-settings-report/medical-test-settings-report.component";
import {MedicalTestSettingsReportTemplateCategoryListComponent} from "./components/medical-test-settings-report/medical-test-settings-report-template-category-list/medical-test-settings-report-template-category-list.component";
import {MedicalTestSettingsReportTemplateCategoryDetailComponent} from "./components/medical-test-settings-report/medical-test-settings-report-template-category-list/medical-test-settings-report-template-category-detail/medical-test-settings-report-template-category-detail.component";
import {InventorySettingsItemManagementComponent} from "./components/inventory-settings-item-management/inventory-settings-item-management.component";
import {InventorySettingsItemManagementDetailComponent} from "./components/inventory-settings-item-management/inventory-settings-item-management-detail/inventory-settings-item-management-detail.component";
import { TreatmentSettingsChargeableItemsComponent } from './components/treatment-settings-chargeable-category/treatment-settings-chargeable-items/treatment-settings-chargeable-items.component';
import {ChargeAdminListComponent} from "./components/charge-admin-list/charge-admin-list.component";
import { TreatmentSettingsChargeableCategoryComponent } from './components/treatment-settings-chargeable-category/treatment-settings-chargeable-category.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    Ng2Bs3ModalModule,
    TreeModule,
    AngularSplitModule,
    MyDatePickerModule,
    UiSwitchModule,
    NgxPaginationModule
  ],
  declarations: [
    QueryBarComponent,
    EditorComponent,
    FieldEditComponent,
    TabsComponent,

    MedicalTestSettingsReportComponent,
    MedicalTestSettingsReportTemplateCategoryListComponent,
    MedicalTestSettingsReportTemplateCategoryDetailComponent,
    InventorySettingsItemManagementComponent,
    InventorySettingsItemManagementDetailComponent,
    TreatmentSettingsChargeableItemsComponent,
    ChargeAdminListComponent,
    TreatmentSettingsChargeableCategoryComponent
  ],
  exports:
    [
      EditorComponent,
      TabsComponent,
      FieldEditComponent,
      QueryBarComponent,

      CommonModule,
      FormsModule,
      ReactiveFormsModule,
      HttpModule,
      HttpClientModule,
      RouterModule,
      Ng2Bs3ModalModule,
      TreeModule,
      AngularSplitModule,
      MyDatePickerModule,
      UiSwitchModule,
      NgxPaginationModule,

      MedicalTestSettingsReportComponent,
      MedicalTestSettingsReportTemplateCategoryListComponent,
      MedicalTestSettingsReportTemplateCategoryDetailComponent,
      InventorySettingsItemManagementComponent,
      InventorySettingsItemManagementDetailComponent,
      TreatmentSettingsChargeableItemsComponent,
      ChargeAdminListComponent,
      TreatmentSettingsChargeableCategoryComponent
    ]

})
export class SharedModule {
}
