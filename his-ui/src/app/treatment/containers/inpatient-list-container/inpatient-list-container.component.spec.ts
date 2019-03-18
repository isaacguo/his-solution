import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InpatientListContainerComponent } from './inpatient-list-container.component';

describe('InpatientListContainerComponent', () => {
  let component: InpatientListContainerComponent;
  let fixture: ComponentFixture<InpatientListContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InpatientListContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InpatientListContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
