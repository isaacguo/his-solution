import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsRoomDetailContainerComponent } from './treatment-settings-room-detail-container.component';

describe('TreatmentSettingsRoomDetailContainerComponent', () => {
  let component: TreatmentSettingsRoomDetailContainerComponent;
  let fixture: ComponentFixture<TreatmentSettingsRoomDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsRoomDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsRoomDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
