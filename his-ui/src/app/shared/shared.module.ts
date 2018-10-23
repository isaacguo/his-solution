import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";
import {NgxPaginationModule} from "ngx-pagination";
import {UiSwitchModule} from "ngx-ui-switch";
import {MyDatePickerModule} from "mydatepicker";
import {AngularSplitModule} from "angular-split";
import {TreeModule} from "angular-tree-component";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {QueryBarComponent} from "./components/query-bar/query-bar.component";
import {FieldEditComponent} from "./components/field-edit/field-edit.component";
import {CategoryToolBarComponent} from './components/category-tool-bar/category-tool-bar.component';
import {CheckboxComponent} from "./components/checkbox/checkbox.component";
import {PetGenderEnumPipe} from "./pipes/pet-gender-enum.pipe";
import { RegistrationStatusEnumPipe } from './pipes/registration-status-enum.pipe';
import { GenderEnumPipe } from './pipes/gender-enum.pipe';

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
    NgxPaginationModule,
  ],
  declarations: [QueryBarComponent,
    FieldEditComponent,
    CategoryToolBarComponent,
    CheckboxComponent,
    PetGenderEnumPipe,
    RegistrationStatusEnumPipe,
    GenderEnumPipe,


    ],
  exports: [

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
    QueryBarComponent,
    FieldEditComponent,
    CategoryToolBarComponent,
    CheckboxComponent,
    PetGenderEnumPipe,
    RegistrationStatusEnumPipe,
    GenderEnumPipe

  ]
})
export class SharedModule {
}
