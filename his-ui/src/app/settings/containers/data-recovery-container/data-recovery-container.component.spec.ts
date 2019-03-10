import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataRecoveryContainerComponent } from './data-recovery-container.component';

describe('DataRecoveryContainerComponent', () => {
  let component: DataRecoveryContainerComponent;
  let fixture: ComponentFixture<DataRecoveryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataRecoveryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataRecoveryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
