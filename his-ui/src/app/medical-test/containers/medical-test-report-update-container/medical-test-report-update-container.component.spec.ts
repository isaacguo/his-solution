import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestReportUpdateContainerComponent } from './medical-test-report-update-container.component';

describe('MedicalTestReportUpdateContainerComponent', () => {
  let component: MedicalTestReportUpdateContainerComponent;
  let fixture: ComponentFixture<MedicalTestReportUpdateContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestReportUpdateContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestReportUpdateContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
