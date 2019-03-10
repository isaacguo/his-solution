import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsContainerComponent } from './medical-test-settings-container.component';

describe('MedicalTestSettingsContainerComponent', () => {
  let component: MedicalTestSettingsContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
