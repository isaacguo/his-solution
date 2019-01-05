import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportManagementDetailComponent } from './import-management-detail.component';

describe('ImportManagementDetailComponent', () => {
  let component: ImportManagementDetailComponent;
  let fixture: ComponentFixture<ImportManagementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportManagementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportManagementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
