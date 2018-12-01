import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsDepartmentDetailContainerComponent } from './medical-test-settings-department-detail-container.component';

describe('MedicalTestSettingsDepartmentDetailContainerComponent', () => {
  let component: MedicalTestSettingsDepartmentDetailContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsDepartmentDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsDepartmentDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsDepartmentDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
