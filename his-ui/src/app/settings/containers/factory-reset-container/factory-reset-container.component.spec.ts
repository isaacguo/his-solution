import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FactoryResetContainerComponent } from './factory-reset-container.component';

describe('FactoryResetContainerComponent', () => {
  let component: FactoryResetContainerComponent;
  let fixture: ComponentFixture<FactoryResetContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FactoryResetContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FactoryResetContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
