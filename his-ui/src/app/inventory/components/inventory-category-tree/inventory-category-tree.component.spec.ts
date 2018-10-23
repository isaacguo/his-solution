import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryCategoryTreeComponent } from './inventory-category-tree.component';

describe('InventoryCategoryTreeComponent', () => {
  let component: InventoryCategoryTreeComponent;
  let fixture: ComponentFixture<InventoryCategoryTreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryCategoryTreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryCategoryTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
