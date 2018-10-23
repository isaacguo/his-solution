import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportReceiptContainerComponent } from './import-receipt-container.component';

describe('ImportReceiptContainerComponent', () => {
  let component: ImportReceiptContainerComponent;
  let fixture: ComponentFixture<ImportReceiptContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportReceiptContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportReceiptContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
