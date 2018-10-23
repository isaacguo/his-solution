import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventorySettingsItemManagementContainerComponent } from './inventory-settings-item-management-container.component';

describe('InventorySettingsItemManagementContainerComponent', () => {
  let component: InventorySettingsItemManagementContainerComponent;
  let fixture: ComponentFixture<InventorySettingsItemManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventorySettingsItemManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventorySettingsItemManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
