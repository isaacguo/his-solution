import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentCaseDetailComponent } from './treatment-case-detail.component';

describe('TreatmentCaseDetailComponent', () => {
  let component: TreatmentCaseDetailComponent;
  let fixture: ComponentFixture<TreatmentCaseDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentCaseDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentCaseDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
