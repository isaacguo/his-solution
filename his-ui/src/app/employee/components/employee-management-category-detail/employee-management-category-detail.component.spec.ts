import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementCategoryDetailComponent } from './employee-management-category-detail.component';

describe('EmployeeManagementCategoryDetailComponent', () => {
  let component: EmployeeManagementCategoryDetailComponent;
  let fixture: ComponentFixture<EmployeeManagementCategoryDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementCategoryDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementCategoryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
