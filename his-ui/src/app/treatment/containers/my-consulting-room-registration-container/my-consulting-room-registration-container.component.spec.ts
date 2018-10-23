import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyConsultingRoomRegistrationContainerComponent } from './my-consulting-room-registration-container.component';

describe('MyConsultingRoomRegistrationContainerComponent', () => {
  let component: MyConsultingRoomRegistrationContainerComponent;
  let fixture: ComponentFixture<MyConsultingRoomRegistrationContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyConsultingRoomRegistrationContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyConsultingRoomRegistrationContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
