import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacyDispensingContainerComponent } from './pharmacy-dispensing-container.component';

describe('PharmacyDispensingContainerComponent', () => {
  let component: PharmacyDispensingContainerComponent;
  let fixture: ComponentFixture<PharmacyDispensingContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmacyDispensingContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyDispensingContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
