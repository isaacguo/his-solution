import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementRequestCreateUpdateComponent } from './procurement-request-create-update.component';

describe('ProcurementRequestCreateUpdateComponent', () => {
  let component: ProcurementRequestCreateUpdateComponent;
  let fixture: ComponentFixture<ProcurementRequestCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementRequestCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementRequestCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
