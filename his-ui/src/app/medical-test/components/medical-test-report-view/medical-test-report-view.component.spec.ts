import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestReportViewComponent} from './medical-test-report-view.component';

describe('MedicalTestReportViewComponent', () => {
  let component: MedicalTestReportViewComponent;
  let fixture: ComponentFixture<MedicalTestReportViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestReportViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestReportViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
