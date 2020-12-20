import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgnosticOrSemanticToolbarIconComponent } from './agnostic-or-semantic-toolbar-icon.component';

describe('AgnosticToolbarIconComponent', () => {
  let component: AgnosticOrSemanticToolbarIconComponent;
  let fixture: ComponentFixture<AgnosticOrSemanticToolbarIconComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgnosticOrSemanticToolbarIconComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgnosticOrSemanticToolbarIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
