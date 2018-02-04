import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CallNextComponent } from './call-next.component';

describe('CallNextComponent', () => {
  let component: CallNextComponent;
  let fixture: ComponentFixture<CallNextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CallNextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CallNextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
