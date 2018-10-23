import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementSettingsVendorsComponent } from './procurement-settings-vendors.component';

describe('ProcurementSettingsVendorsComponent', () => {
  let component: ProcurementSettingsVendorsComponent;
  let fixture: ComponentFixture<ProcurementSettingsVendorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementSettingsVendorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementSettingsVendorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
