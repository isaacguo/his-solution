import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FrontDeskContainerComponent } from './front-desk-container.component';

describe('FrontDeskContainerComponent', () => {
  let component: FrontDeskContainerComponent;
  let fixture: ComponentFixture<FrontDeskContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FrontDeskContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FrontDeskContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
