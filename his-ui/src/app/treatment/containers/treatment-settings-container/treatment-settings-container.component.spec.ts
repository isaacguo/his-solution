import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsContainerComponent } from './treatment-settings-container.component';

describe('TreatmentSettingsContainerComponent', () => {
  let component: TreatmentSettingsContainerComponent;
  let fixture: ComponentFixture<TreatmentSettingsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
