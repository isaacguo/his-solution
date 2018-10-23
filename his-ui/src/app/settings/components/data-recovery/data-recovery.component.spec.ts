import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataRecoveryComponent } from './data-recovery.component';

describe('DataRecoveryComponent', () => {
  let component: DataRecoveryComponent;
  let fixture: ComponentFixture<DataRecoveryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataRecoveryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataRecoveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
