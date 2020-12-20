import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { StateComponent } from './state.component';

describe('StateComponent', () => {
  let component: StateComponent;
  let fixture: ComponentFixture<StateComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ StateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
