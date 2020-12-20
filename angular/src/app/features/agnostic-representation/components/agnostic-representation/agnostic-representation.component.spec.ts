import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { AgnosticRepresentationComponent } from './agnostic-representation.component';

describe('AgnosticRepresentationComponent', () => {
  let component: AgnosticRepresentationComponent;
  let fixture: ComponentFixture<AgnosticRepresentationComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ AgnosticRepresentationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgnosticRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
