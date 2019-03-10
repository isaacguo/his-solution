import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacyDispensingComponent } from './pharmacy-dispensing.component';

describe('PharmacyDispensingComponent', () => {
  let component: PharmacyDispensingComponent;
  let fixture: ComponentFixture<PharmacyDispensingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmacyDispensingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyDispensingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
