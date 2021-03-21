import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgnosticToolbarComponent } from './agnostic-toolbar.component';

describe('AgnosticToolbarComponent', () => {
  let component: AgnosticToolbarComponent;
  let fixture: ComponentFixture<AgnosticToolbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgnosticToolbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgnosticToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
