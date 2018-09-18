import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TreatmentRoomEmployeeListComponent} from './treatment-room-employee-list.component';

describe('TreatmentRoomEmployeeListComponent', () => {
  let component: TreatmentRoomEmployeeListComponent;
  let fixture: ComponentFixture<TreatmentRoomEmployeeListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentRoomEmployeeListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentRoomEmployeeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
