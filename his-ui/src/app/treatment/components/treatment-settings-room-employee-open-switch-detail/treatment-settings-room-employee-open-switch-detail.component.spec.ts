import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent } from './treatment-settings-room-employee-open-switch-detail.component';

describe('TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent', () => {
  let component: TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent;
  let fixture: ComponentFixture<TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
