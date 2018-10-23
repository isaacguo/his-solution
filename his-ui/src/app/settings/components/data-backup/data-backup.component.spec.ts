import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataBackupComponent } from './data-backup.component';

describe('DataBackupComponent', () => {
  let component: DataBackupComponent;
  let fixture: ComponentFixture<DataBackupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataBackupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataBackupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
