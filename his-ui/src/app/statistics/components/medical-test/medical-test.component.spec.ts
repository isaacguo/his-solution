import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestComponent } from './medical-test.component';

describe('MedicalTestComponent', () => {
  let component: MedicalTestComponent;
  let fixture: ComponentFixture<MedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
