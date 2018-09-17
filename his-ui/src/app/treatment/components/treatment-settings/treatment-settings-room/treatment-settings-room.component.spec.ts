import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsRoomComponent } from './treatment-settings-room.component';

describe('TreatmentSettingsRoomComponent', () => {
  let component: TreatmentSettingsRoomComponent;
  let fixture: ComponentFixture<TreatmentSettingsRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
