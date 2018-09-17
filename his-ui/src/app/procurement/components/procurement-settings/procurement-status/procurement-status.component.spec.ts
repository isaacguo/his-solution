import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementStatusComponent } from './procurement-status.component';

describe('ProcurementStatusComponent', () => {
  let component: ProcurementStatusComponent;
  let fixture: ComponentFixture<ProcurementStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
