import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TreatmentCommentsContainerComponent} from './treatment-comments-container.component';

describe('TreatmentCommentsContainerComponent', () => {
  let component: TreatmentCommentsContainerComponent;
  let fixture: ComponentFixture<TreatmentCommentsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentCommentsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentCommentsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
