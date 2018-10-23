import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeCreateUpdateContainerComponent } from './employee-create-update-container.component';

describe('EmployeeCreateUpdateContainerComponent', () => {
  let component: EmployeeCreateUpdateContainerComponent;
  let fixture: ComponentFixture<EmployeeCreateUpdateContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeCreateUpdateContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeCreateUpdateContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
