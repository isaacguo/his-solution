import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentContainerComponent } from './treatment-container.component';

describe('TreatmentContainerComponent', () => {
  let component: TreatmentContainerComponent;
  let fixture: ComponentFixture<TreatmentContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
