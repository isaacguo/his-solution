import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ImportSheetCreateUpdateComponent} from './import-sheet-create-update.component';

describe('ImportSheetCreateUpdateComponent', () => {
  let component: ImportSheetCreateUpdateComponent;
  let fixture: ComponentFixture<ImportSheetCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportSheetCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportSheetCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
