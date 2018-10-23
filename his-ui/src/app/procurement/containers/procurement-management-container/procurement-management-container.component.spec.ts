import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementManagementContainerComponent } from './procurement-management-container.component';

describe('ProcurementManagementContainerComponent', () => {
  let component: ProcurementManagementContainerComponent;
  let fixture: ComponentFixture<ProcurementManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
