import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VendorCreateUpdateComponent } from './vendor-create-update.component';

describe('VendorCreateUpdateComponent', () => {
  let component: VendorCreateUpdateComponent;
  let fixture: ComponentFixture<VendorCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
