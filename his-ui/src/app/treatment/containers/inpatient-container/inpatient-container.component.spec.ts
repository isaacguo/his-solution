import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InpatientContainerComponent } from './inpatient-container.component';

describe('InpatientContainerComponent', () => {
  let component: InpatientContainerComponent;
  let fixture: ComponentFixture<InpatientContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InpatientContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InpatientContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
