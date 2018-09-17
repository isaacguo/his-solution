import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportManagementComponent } from './export-management.component';

describe('ExportManagementComponent', () => {
  let component: ExportManagementComponent;
  let fixture: ComponentFixture<ExportManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
