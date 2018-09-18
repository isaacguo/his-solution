import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestSettingsDepartmentDetailComponent} from './medical-test-settings-department-detail.component';

describe('MedicalTestSettingsDepartmentDetailComponent', () => {
  let component: MedicalTestSettingsDepartmentDetailComponent;
  let fixture: ComponentFixture<MedicalTestSettingsDepartmentDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsDepartmentDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsDepartmentDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
