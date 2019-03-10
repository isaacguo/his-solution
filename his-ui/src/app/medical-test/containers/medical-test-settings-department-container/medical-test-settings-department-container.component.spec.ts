import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsDepartmentContainerComponent } from './medical-test-settings-department-container.component';

describe('MedicalTestSettingsDepartmentContainerComponent', () => {
  let component: MedicalTestSettingsDepartmentContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsDepartmentContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsDepartmentContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsDepartmentContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
