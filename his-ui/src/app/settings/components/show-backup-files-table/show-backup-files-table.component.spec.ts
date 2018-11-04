import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowBackupFilesTableComponent } from './show-backup-files-table.component';

describe('ShowBackupFilesTableComponent', () => {
  let component: ShowBackupFilesTableComponent;
  let fixture: ComponentFixture<ShowBackupFilesTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowBackupFilesTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowBackupFilesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
