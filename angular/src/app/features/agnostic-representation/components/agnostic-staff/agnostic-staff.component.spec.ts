import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AgnosticStaffComponent } from './agnostic-staff.component';

describe('AgnosticStaffComponent', () => {
  let component: AgnosticStaffComponent;
  let fixture: ComponentFixture<AgnosticStaffComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AgnosticStaffComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgnosticStaffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
