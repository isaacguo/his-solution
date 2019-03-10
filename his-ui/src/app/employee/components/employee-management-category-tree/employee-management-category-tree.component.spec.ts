import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementCategoryTreeComponent } from './employee-management-category-tree.component';

describe('EmployeeManagementCategoryTreeComponent', () => {
  let component: EmployeeManagementCategoryTreeComponent;
  let fixture: ComponentFixture<EmployeeManagementCategoryTreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementCategoryTreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementCategoryTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
