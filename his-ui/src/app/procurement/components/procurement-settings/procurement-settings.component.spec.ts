import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementSettingsComponent } from './procurement-settings.component';

describe('ProcurementSettingsComponent', () => {
  let component: ProcurementSettingsComponent;
  let fixture: ComponentFixture<ProcurementSettingsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementSettingsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementSettingsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
