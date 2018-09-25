import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsChargeableCategoryComponent } from './treatment-settings-chargeable-category.component';

describe('TreatmentSettingsChargeableCategoryComponent', () => {
  let component: TreatmentSettingsChargeableCategoryComponent;
  let fixture: ComponentFixture<TreatmentSettingsChargeableCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsChargeableCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsChargeableCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
