import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmnetPrescriptionDetailComponent } from './treatmnet-prescription-detail.component';

describe('TreatmnetPrescriptionDetailComponent', () => {
  let component: TreatmnetPrescriptionDetailComponent;
  let fixture: ComponentFixture<TreatmnetPrescriptionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmnetPrescriptionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmnetPrescriptionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
