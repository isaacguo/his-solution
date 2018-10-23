import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceContainerComponent } from './finance-container.component';

describe('FinanceContainerComponent', () => {
  let component: FinanceContainerComponent;
  let fixture: ComponentFixture<FinanceContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
