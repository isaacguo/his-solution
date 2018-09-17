import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsComponent } from './medical-test-settings.component';

describe('MedicalTestSettingsComponent', () => {
  let component: MedicalTestSettingsComponent;
  let fixture: ComponentFixture<MedicalTestSettingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
