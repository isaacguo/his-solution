import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsRoomEmployeeOpenSwitchComponent } from './treatment-settings-room-employee-open-switch.component';

describe('TreatmentSettingsRoomEmployeeOpenSwitchComponent', () => {
  let component: TreatmentSettingsRoomEmployeeOpenSwitchComponent;
  let fixture: ComponentFixture<TreatmentSettingsRoomEmployeeOpenSwitchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsRoomEmployeeOpenSwitchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsRoomEmployeeOpenSwitchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
