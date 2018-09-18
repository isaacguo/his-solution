import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestQueryComponent} from './medical-test-query.component';

describe('MedicalTestQueryComponent', () => {
  let component: MedicalTestQueryComponent;
  let fixture: ComponentFixture<MedicalTestQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
