import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestContainerComponent } from './medical-test-container.component';

describe('MedicalTestContainerComponent', () => {
  let component: MedicalTestContainerComponent;
  let fixture: ComponentFixture<MedicalTestContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
