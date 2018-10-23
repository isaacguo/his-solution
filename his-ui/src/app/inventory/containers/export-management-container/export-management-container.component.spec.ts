import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportManagementContainerComponent } from './export-management-container.component';

describe('ExportManagementContainerComponent', () => {
  let component: ExportManagementContainerComponent;
  let fixture: ComponentFixture<ExportManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
