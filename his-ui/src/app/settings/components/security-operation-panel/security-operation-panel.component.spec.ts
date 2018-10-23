import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {SecurityOperationPanelComponent} from './security-operation-panel.component';

describe('SecurityOperationPanelComponent', () => {
  let component: SecurityOperationPanelComponent;
  let fixture: ComponentFixture<SecurityOperationPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecurityOperationPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecurityOperationPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
