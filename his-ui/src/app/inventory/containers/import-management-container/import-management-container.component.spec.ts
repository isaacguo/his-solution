import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportManagementContainerComponent } from './import-management-container.component';

describe('ImportManagementContainerComponent', () => {
  let component: ImportManagementContainerComponent;
  let fixture: ComponentFixture<ImportManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
