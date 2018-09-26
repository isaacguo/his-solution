import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentItemCreateUpdateComponent } from './treatment-item-create-update.component';

describe('TreatmentItemCreateUpdateComponent', () => {
  let component: TreatmentItemCreateUpdateComponent;
  let fixture: ComponentFixture<TreatmentItemCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentItemCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentItemCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
