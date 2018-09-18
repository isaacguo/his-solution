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

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
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
      HttpClientModule,
      RouterModule,
      Ng2Bs3ModalModule,
      TreeModule,
      AngularSplitModule,
      MyDatePickerModule,
      UiSwitchModule,
      NgxPaginationModule
    ]

})
export class SharedModule {
}
