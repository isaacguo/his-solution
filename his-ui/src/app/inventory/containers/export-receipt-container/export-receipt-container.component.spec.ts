import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExportReceiptContainerComponent } from './export-receipt-container.component';

describe('ExportReceiptContainerComponent', () => {
  let component: ExportReceiptContainerComponent;
  let fixture: ComponentFixture<ExportReceiptContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportReceiptContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportReceiptContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
