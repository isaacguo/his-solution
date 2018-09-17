import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacyMedicineDispensingManagementListComponent } from './pharmacy-medicine-dispensing-management-list.component';

describe('PharmacyMedicineDispensingManagementListComponent', () => {
  let component: PharmacyMedicineDispensingManagementListComponent;
  let fixture: ComponentFixture<PharmacyMedicineDispensingManagementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmacyMedicineDispensingManagementListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyMedicineDispensingManagementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
