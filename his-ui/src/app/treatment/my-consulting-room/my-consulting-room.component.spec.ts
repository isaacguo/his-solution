import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyConsultingRoomComponent } from './my-consulting-room.component';

describe('MyConsultingRoomComponent', () => {
  let component: MyConsultingRoomComponent;
  let fixture: ComponentFixture<MyConsultingRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyConsultingRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyConsultingRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
