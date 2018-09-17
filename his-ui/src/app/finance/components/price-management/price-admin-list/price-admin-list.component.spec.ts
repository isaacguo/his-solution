import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PriceAdminListComponent } from './price-admin-list.component';

describe('PriceAdminListComponent', () => {
  let component: PriceAdminListComponent;
  let fixture: ComponentFixture<PriceAdminListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PriceAdminListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PriceAdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
