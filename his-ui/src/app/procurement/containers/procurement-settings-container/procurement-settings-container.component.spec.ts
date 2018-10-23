import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementSettingsContainerComponent } from './procurement-settings-container.component';

describe('ProcurementSettingsContainerComponent', () => {
  let component: ProcurementSettingsContainerComponent;
  let fixture: ComponentFixture<ProcurementSettingsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementSettingsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementSettingsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
