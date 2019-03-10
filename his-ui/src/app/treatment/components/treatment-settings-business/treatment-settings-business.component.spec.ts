import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsBusinessComponent } from './treatment-settings-business.component';

describe('TreatmentSettingsBusinessComponent', () => {
  let component: TreatmentSettingsBusinessComponent;
  let fixture: ComponentFixture<TreatmentSettingsBusinessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsBusinessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsBusinessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
