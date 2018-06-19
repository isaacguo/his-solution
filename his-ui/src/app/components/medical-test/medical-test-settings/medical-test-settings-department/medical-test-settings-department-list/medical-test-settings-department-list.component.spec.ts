import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsDepartmentListComponent } from './medical-test-settings-department-list.component';

describe('MedicalTestSettingsDepartmentListComponent', () => {
  let component: MedicalTestSettingsDepartmentListComponent;
  let fixture: ComponentFixture<MedicalTestSettingsDepartmentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsDepartmentListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsDepartmentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
