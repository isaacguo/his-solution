import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ContactCreateUpdateComponent} from './contact-create-update.component';

describe('ContactCreateUpdateComponent', () => {
  let component: ContactCreateUpdateComponent;
  let fixture: ComponentFixture<ContactCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContactCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
