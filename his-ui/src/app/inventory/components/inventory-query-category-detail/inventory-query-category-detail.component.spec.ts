import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryQueryCategoryDetailComponent } from './inventory-query-category-detail.component';

describe('InventoryQueryCategoryDetailComponent', () => {
  let component: InventoryQueryCategoryDetailComponent;
  let fixture: ComponentFixture<InventoryQueryCategoryDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryQueryCategoryDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryQueryCategoryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
