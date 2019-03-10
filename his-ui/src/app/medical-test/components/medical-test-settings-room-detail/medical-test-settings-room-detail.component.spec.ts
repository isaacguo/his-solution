import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsRoomDetailComponent } from './medical-test-settings-room-detail.component';

describe('MedicalTestSettingsRoomDetailComponent', () => {
  let component: MedicalTestSettingsRoomDetailComponent;
  let fixture: ComponentFixture<MedicalTestSettingsRoomDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsRoomDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsRoomDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
