import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentCaseDetailContainerComponent } from './treatment-case-detail-container.component';

describe('TreatmentCaseDetailContainerComponent', () => {
  let component: TreatmentCaseDetailContainerComponent;
  let fixture: ComponentFixture<TreatmentCaseDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentCaseDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentCaseDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
