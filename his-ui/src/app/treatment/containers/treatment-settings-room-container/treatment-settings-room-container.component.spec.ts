import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsRoomContainerComponent } from './treatment-settings-room-container.component';

describe('TreatmentSettingsRoomContainerComponent', () => {
  let component: TreatmentSettingsRoomContainerComponent;
  let fixture: ComponentFixture<TreatmentSettingsRoomContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsRoomContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsRoomContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
