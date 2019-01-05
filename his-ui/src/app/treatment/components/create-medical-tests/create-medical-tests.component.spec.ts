import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMedicalTestsComponent } from './create-medical-tests.component';

describe('CreateMedicalTestsComponent', () => {
  let component: CreateMedicalTestsComponent;
  let fixture: ComponentFixture<CreateMedicalTestsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateMedicalTestsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMedicalTestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
