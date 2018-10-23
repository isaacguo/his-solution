import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportManagementComponent } from './import-management.component';

describe('ImportManagementComponent', () => {
  let component: ImportManagementComponent;
  let fixture: ComponentFixture<ImportManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
