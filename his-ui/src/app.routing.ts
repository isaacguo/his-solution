import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {IndexComponent} from "./app/components/index/index.component";
import {LoginComponent} from "./app/components/login/login.component";
import {FrontDeskComponent} from "./app/components/front-desk/front-desk.component";
import {TreatmentComponent} from "./app/components/treatment/treatment.component";
import {TestingComponent} from "./app/components/testing/testing.component";
import {ImagesComponent} from "./app/components/images/images.component";
import {PharmacyComponent} from "./app/components/pharmacy/pharmacy.component";
import {ProfilesComponent} from "./app/components/profiles/profiles.component";
import {MembersComponent} from "./app/components/members/members.component";
import {PetsComponent} from "./app/components/pets/pets.component";
import {BusinessComponent} from "./app/components/business/business.component";
import {ProcurementComponent} from "./app/components/procurement/procurement.component";
import {InventoryComponent} from "./app/components/inventory/inventory.component";
import {AnalysisComponent} from "./app/components/analysis/analysis.component";
import {DataComponent} from "./app/components/data/data.component";
import {SettingsComponent} from "./app/components/settings/settings.component";


const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent,
    children: [
      {
        path: 'frontdesk',
        component: FrontDeskComponent
      },
      {
        path: 'treatment',
        component: TreatmentComponent
      },
      {
        path: 'testing',
        component:TestingComponent
      },
      {
        path: 'images',
        component: ImagesComponent
      },
      {
        path: 'pharmacy',
        component: PharmacyComponent
      },
      {
        path: 'profiles',
        component: ProfilesComponent
      },
      {
        path: 'members',
        component: MembersComponent
      },
      {
        path: 'pets',
        component: PetsComponent
      },
      {
        path: 'business',
        component: BusinessComponent
      },
      {
        path: 'procurement',
        component: ProcurementComponent
      },
      {
        path: 'inventory',
        component: InventoryComponent
      },
      {
        path: 'analysis',
        component: AnalysisComponent
      },
      {
        path: 'data',
        component: DataComponent
      },
      {
        path: 'settings',
        component: SettingsComponent
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  }

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
