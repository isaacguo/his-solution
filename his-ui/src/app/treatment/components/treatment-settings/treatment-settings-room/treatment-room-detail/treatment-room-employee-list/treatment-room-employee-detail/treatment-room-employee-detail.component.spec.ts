import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TreatmentRoomEmployeeDetailComponent} from './treatment-room-employee-detail.component';

describe('TreatmentRoomEmployeeDetailComponent', () => {
  let component: TreatmentRoomEmployeeDetailComponent;
  let fixture: ComponentFixture<TreatmentRoomEmployeeDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentRoomEmployeeDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentRoomEmployeeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
