import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyConsultingRoomRegistrationListComponent } from './my-consulting-room-registration-list.component';

describe('MyConsultingRoomRegistrationListComponent', () => {
  let component: MyConsultingRoomRegistrationListComponent;
  let fixture: ComponentFixture<MyConsultingRoomRegistrationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyConsultingRoomRegistrationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyConsultingRoomRegistrationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
