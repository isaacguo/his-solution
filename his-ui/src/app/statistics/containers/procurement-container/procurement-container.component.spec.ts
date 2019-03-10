import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementContainerComponent } from './procurement-container.component';

describe('ProcurementContainerComponent', () => {
  let component: ProcurementContainerComponent;
  let fixture: ComponentFixture<ProcurementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
