import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventorySettingsWarehourseComponent } from './inventory-settings-warehourse.component';

describe('InventorySettingsWarehourseComponent', () => {
  let component: InventorySettingsWarehourseComponent;
  let fixture: ComponentFixture<InventorySettingsWarehourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventorySettingsWarehourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventorySettingsWarehourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
