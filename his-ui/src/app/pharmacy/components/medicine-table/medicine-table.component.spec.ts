import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineTableComponent } from './medicine-table.component';

describe('MedicineTableComponent', () => {
  let component: MedicineTableComponent;
  let fixture: ComponentFixture<MedicineTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicineTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
