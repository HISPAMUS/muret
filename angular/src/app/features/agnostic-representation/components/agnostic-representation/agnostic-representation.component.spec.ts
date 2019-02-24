import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgnosticRepresentationComponent } from './agnostic-representation.component';

describe('AgnosticRepresentationComponent', () => {
  let component: AgnosticRepresentationComponent;
  let fixture: ComponentFixture<AgnosticRepresentationComponent>;

  beforeEach(async(() => {
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
