import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementSettingsVendorsContainerComponent } from './procurement-settings-vendors-container.component';

describe('ProcurementSettingsVendorsContainerComponent', () => {
  let component: ProcurementSettingsVendorsContainerComponent;
  let fixture: ComponentFixture<ProcurementSettingsVendorsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementSettingsVendorsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementSettingsVendorsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
