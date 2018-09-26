import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentSettingsBusinessContainerComponent } from './treatment-settings-business-container.component';

describe('TreatmentSettingsBusinessContainerComponent', () => {
  let component: TreatmentSettingsBusinessContainerComponent;
  let fixture: ComponentFixture<TreatmentSettingsBusinessContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentSettingsBusinessContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentSettingsBusinessContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
