import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ConfirmDialogWarningComponent } from './confirm-dialog-warning.component';

describe('ConfirmDialogWarningComponent', () => {
  let component: ConfirmDialogWarningComponent;
  let fixture: ComponentFixture<ConfirmDialogWarningComponent>;

  beforeEach(waitForAsync(() => {
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
