import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyConsultingRoomContainerComponent } from './my-consulting-room-container.component';

describe('MyConsultingRoomContainerComponent', () => {
  let component: MyConsultingRoomContainerComponent;
  let fixture: ComponentFixture<MyConsultingRoomContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyConsultingRoomContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyConsultingRoomContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
