import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicineContainerComponent } from './medicine-container.component';

describe('MedicineContainerComponent', () => {
  let component: MedicineContainerComponent;
  let fixture: ComponentFixture<MedicineContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicineContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicineContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
