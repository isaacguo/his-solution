import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DispensingDetailContainerComponent } from './dispensing-detail-container.component';

describe('DispensingDetailContainerComponent', () => {
  let component: DispensingDetailContainerComponent;
  let fixture: ComponentFixture<DispensingDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DispensingDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DispensingDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
