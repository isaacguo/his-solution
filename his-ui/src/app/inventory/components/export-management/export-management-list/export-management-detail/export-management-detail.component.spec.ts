import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ExportManagementDetailComponent} from './export-management-detail.component';

describe('ExportManagementDetailComponent', () => {
  let component: ExportManagementDetailComponent;
  let fixture: ComponentFixture<ExportManagementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportManagementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportManagementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
