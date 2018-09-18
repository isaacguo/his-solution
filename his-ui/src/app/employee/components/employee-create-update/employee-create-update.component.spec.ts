import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeCreateUpdateComponent} from './employee-create-update.component';

describe('EmployeeCreateUpdateComponent', () => {
  let component: EmployeeCreateUpdateComponent;
  let fixture: ComponentFixture<EmployeeCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
