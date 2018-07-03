import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinaceQueryComponent } from './finace-query.component';

describe('FinaceQueryComponent', () => {
  let component: FinaceQueryComponent;
  let fixture: ComponentFixture<FinaceQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinaceQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinaceQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
