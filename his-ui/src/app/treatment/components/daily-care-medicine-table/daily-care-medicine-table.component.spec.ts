import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyCareMedicineTableComponent } from './daily-care-medicine-table.component';

describe('DailyCareMedicineTableComponent', () => {
  let component: DailyCareMedicineTableComponent;
  let fixture: ComponentFixture<DailyCareMedicineTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyCareMedicineTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyCareMedicineTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
