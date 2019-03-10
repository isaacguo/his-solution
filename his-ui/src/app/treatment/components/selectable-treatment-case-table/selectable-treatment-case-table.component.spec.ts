import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectableTreatmentCaseTableComponent } from './selectable-treatment-case-table.component';

describe('SelectableTreatmentCaseTableComponent', () => {
  let component: SelectableTreatmentCaseTableComponent;
  let fixture: ComponentFixture<SelectableTreatmentCaseTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectableTreatmentCaseTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectableTreatmentCaseTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
