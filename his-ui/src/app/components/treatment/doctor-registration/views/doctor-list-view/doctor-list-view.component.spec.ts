import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorListViewComponent } from './doctor-list-view.component';

describe('DoctorListViewComponent', () => {
  let component: DoctorListViewComponent;
  let fixture: ComponentFixture<DoctorListViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorListViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
