import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacyMedicineDispensingManagementComponent } from './pharmacy-medicine-dispensing-management.component';

describe('PharmacyMedicineDispensingManagementComponent', () => {
  let component: PharmacyMedicineDispensingManagementComponent;
  let fixture: ComponentFixture<PharmacyMedicineDispensingManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmacyMedicineDispensingManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyMedicineDispensingManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
