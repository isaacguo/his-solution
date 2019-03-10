import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeOperationBarComponent } from './employee-operation-bar.component';

describe('EmployeeOperationBarComponent', () => {
  let component: EmployeeOperationBarComponent;
  let fixture: ComponentFixture<EmployeeOperationBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeOperationBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeOperationBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
