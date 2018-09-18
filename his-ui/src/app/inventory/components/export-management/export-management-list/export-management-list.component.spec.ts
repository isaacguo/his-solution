import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ExportManagementListComponent} from './export-management-list.component';

describe('ExportManagementListComponent', () => {
  let component: ExportManagementListComponent;
  let fixture: ComponentFixture<ExportManagementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportManagementListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportManagementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
