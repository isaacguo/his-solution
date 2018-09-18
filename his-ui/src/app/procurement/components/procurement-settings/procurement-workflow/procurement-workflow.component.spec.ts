import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementWorkflowComponent} from './procurement-workflow.component';

describe('ProcurementWorkflowComponent', () => {
  let component: ProcurementWorkflowComponent;
  let fixture: ComponentFixture<ProcurementWorkflowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementWorkflowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementWorkflowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
