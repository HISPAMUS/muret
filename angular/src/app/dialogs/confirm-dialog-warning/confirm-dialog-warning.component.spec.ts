import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmDialogWarningComponent } from './confirm-dialog-warning.component';

describe('ConfirmDialogWarningComponent', () => {
  let component: ConfirmDialogWarningComponent;
  let fixture: ComponentFixture<ConfirmDialogWarningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfirmDialogWarningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmDialogWarningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
