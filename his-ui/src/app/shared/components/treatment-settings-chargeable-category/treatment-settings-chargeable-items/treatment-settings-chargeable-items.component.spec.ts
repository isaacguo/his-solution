import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsChargeableItemsComponent } from './treatment-settings-chargeable-items.component';

describe('TreatmentSettingsChargeableItemsComponent', () => {
  let component: TreatmentSettingsChargeableItemsComponent;
  let fixture: ComponentFixture<TreatmentSettingsChargeableItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsChargeableItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsChargeableItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
