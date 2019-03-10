import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportTemplateListComponent } from './medical-test-settings-report-template-list.component';

describe('MedicalTestSettingsReportTemplateListComponent', () => {
  let component: MedicalTestSettingsReportTemplateListComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplateListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplateListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplateListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
