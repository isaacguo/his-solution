import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacyMedicineDispensingManagementDetailComponent } from './pharmacy-medicine-dispensing-management-detail.component';

describe('PharmacyMedicineDispensingManagementDetailComponent', () => {
  let component: PharmacyMedicineDispensingManagementDetailComponent;
  let fixture: ComponentFixture<PharmacyMedicineDispensingManagementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmacyMedicineDispensingManagementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyMedicineDispensingManagementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
