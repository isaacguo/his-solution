import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsRoomOpenSwitchComponent } from './treatment-settings-room-open-switch.component';

describe('TreatmentSettingsRoomOpenSwitchComponent', () => {
  let component: TreatmentSettingsRoomOpenSwitchComponent;
  let fixture: ComponentFixture<TreatmentSettingsRoomOpenSwitchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsRoomOpenSwitchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsRoomOpenSwitchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
