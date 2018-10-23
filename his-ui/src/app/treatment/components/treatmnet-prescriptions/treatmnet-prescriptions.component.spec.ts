import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmnetPrescriptionsComponent } from './treatmnet-prescriptions.component';

describe('TreatmnetPrescriptionsComponent', () => {
  let component: TreatmnetPrescriptionsComponent;
  let fixture: ComponentFixture<TreatmnetPrescriptionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmnetPrescriptionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmnetPrescriptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
