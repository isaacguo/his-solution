import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestSettingsDepartmentComponent} from './medical-test-settings-department.component';

describe('MedicalTestSettingsDepartmentComponent', () => {
  let component: MedicalTestSettingsDepartmentComponent;
  let fixture: ComponentFixture<MedicalTestSettingsDepartmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsDepartmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsDepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
