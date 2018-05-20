import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyConsultingRoomRegistrationDetailComponent } from './my-consulting-room-registration-detail.component';

describe('MyConsultingRoomRegistrationDetailComponent', () => {
  let component: MyConsultingRoomRegistrationDetailComponent;
  let fixture: ComponentFixture<MyConsultingRoomRegistrationDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyConsultingRoomRegistrationDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyConsultingRoomRegistrationDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
