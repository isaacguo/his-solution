import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementRequestComponent} from './procurement-request.component';

describe('ProcurementRequestComponent', () => {
  let component: ProcurementRequestComponent;
  let fixture: ComponentFixture<ProcurementRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
