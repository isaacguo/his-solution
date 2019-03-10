import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacyDispensingDetailComponent } from './pharmacy-dispensing-detail.component';

describe('PharmacyDispensingDetailComponent', () => {
  let component: PharmacyDispensingDetailComponent;
  let fixture: ComponentFixture<PharmacyDispensingDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmacyDispensingDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyDispensingDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
