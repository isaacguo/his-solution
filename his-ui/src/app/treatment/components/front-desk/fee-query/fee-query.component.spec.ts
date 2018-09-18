import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {FeeQueryComponent} from './fee-query.component';

describe('FeeQueryComponent', () => {
  let component: FeeQueryComponent;
  let fixture: ComponentFixture<FeeQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeeQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeeQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
