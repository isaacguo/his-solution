import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataBackupContainerComponent } from './data-backup-container.component';

describe('DataBackupContainerComponent', () => {
  let component: DataBackupContainerComponent;
  let fixture: ComponentFixture<DataBackupContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataBackupContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataBackupContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
