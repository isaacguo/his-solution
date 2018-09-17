import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsComponent } from './treatment-settings.component';

describe('TreatmentSettingsComponent', () => {
  let component: TreatmentSettingsComponent;
  let fixture: ComponentFixture<TreatmentSettingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
