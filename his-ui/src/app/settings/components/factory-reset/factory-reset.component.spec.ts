import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {FactoryResetComponent} from './factory-reset.component';

describe('FactoryResetComponent', () => {
  let component: FactoryResetComponent;
  let fixture: ComponentFixture<FactoryResetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FactoryResetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FactoryResetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
