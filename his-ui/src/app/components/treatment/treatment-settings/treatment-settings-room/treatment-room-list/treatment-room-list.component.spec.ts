import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentRoomListComponent } from './treatment-room-list.component';

describe('TreatmentRoomListComponent', () => {
  let component: TreatmentRoomListComponent;
  let fixture: ComponentFixture<TreatmentRoomListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentRoomListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentRoomListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
