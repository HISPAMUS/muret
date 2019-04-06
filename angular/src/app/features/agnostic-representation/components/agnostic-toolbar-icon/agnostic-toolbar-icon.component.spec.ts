import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgnosticToolbarIconComponent } from './agnostic-toolbar-icon.component';

describe('AgnosticToolbarIconComponent', () => {
  let component: AgnosticToolbarIconComponent;
  let fixture: ComponentFixture<AgnosticToolbarIconComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgnosticToolbarIconComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgnosticToolbarIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
