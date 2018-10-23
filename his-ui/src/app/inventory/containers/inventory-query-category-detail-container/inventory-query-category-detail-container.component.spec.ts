import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryQueryCategoryDetailContainerComponent } from './inventory-query-category-detail-container.component';

describe('InventoryQueryCategoryDetailContainerComponent', () => {
  let component: InventoryQueryCategoryDetailContainerComponent;
  let fixture: ComponentFixture<InventoryQueryCategoryDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryQueryCategoryDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryQueryCategoryDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
