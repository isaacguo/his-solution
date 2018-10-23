import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventorySettingsContainerComponent } from './inventory-settings-container.component';

describe('InventorySettingsContainerComponent', () => {
  let component: InventorySettingsContainerComponent;
  let fixture: ComponentFixture<InventorySettingsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventorySettingsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventorySettingsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
