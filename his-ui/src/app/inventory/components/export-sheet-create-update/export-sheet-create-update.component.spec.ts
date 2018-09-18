import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ExportSheetCreateUpdateComponent} from './export-sheet-create-update.component';

describe('ExportSheetCreateUpdateComponent', () => {
  let component: ExportSheetCreateUpdateComponent;
  let fixture: ComponentFixture<ExportSheetCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExportSheetCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExportSheetCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
