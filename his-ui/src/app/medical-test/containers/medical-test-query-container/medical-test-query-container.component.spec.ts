import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestQueryContainerComponent } from './medical-test-query-container.component';

describe('MedicalTestQueryContainerComponent', () => {
  let component: MedicalTestQueryContainerComponent;
  let fixture: ComponentFixture<MedicalTestQueryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestQueryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestQueryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
