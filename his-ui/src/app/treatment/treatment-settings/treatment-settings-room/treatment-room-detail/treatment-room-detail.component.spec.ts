import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentRoomDetailComponent } from './treatment-room-detail.component';

describe('TreatmentRoomDetailComponent', () => {
  let component: TreatmentRoomDetailComponent;
  let fixture: ComponentFixture<TreatmentRoomDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentRoomDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentRoomDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
