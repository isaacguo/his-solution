import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InpatientListComponent } from './inpatient-list.component';

describe('InpatientListComponent', () => {
  let component: InpatientListComponent;
  let fixture: ComponentFixture<InpatientListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InpatientListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InpatientListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
