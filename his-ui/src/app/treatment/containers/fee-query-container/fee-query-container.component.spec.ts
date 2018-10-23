import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeeQueryContainerComponent } from './fee-query-container.component';

describe('FeeQueryContainerComponent', () => {
  let component: FeeQueryContainerComponent;
  let fixture: ComponentFixture<FeeQueryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeeQueryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeeQueryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
