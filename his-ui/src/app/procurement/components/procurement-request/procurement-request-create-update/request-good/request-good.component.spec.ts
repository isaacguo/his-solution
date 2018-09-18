import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RequestGoodComponent} from './request-good.component';

describe('RequestGoodComponent', () => {
  let component: RequestGoodComponent;
  let fixture: ComponentFixture<RequestGoodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestGoodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestGoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
