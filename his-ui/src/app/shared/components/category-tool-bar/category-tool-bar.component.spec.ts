import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryToolBarComponent } from './category-tool-bar.component';

describe('CategoryToolBarComponent', () => {
  let component: CategoryToolBarComponent;
  let fixture: ComponentFixture<CategoryToolBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryToolBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryToolBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
