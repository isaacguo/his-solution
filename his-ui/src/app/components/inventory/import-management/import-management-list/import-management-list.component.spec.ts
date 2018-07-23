import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportManagementListComponent } from './import-management-list.component';

describe('ImportManagementListComponent', () => {
  let component: ImportManagementListComponent;
  let fixture: ComponentFixture<ImportManagementListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportManagementListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportManagementListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
