import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventorySettingsItemManagementComponent } from './inventory-settings-item-management.component';

describe('InventorySettingsItemManagementComponent', () => {
  let component: InventorySettingsItemManagementComponent;
  let fixture: ComponentFixture<InventorySettingsItemManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventorySettingsItemManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventorySettingsItemManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
