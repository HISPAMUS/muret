import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { LinksModalDialogComponent } from './links-modal-dialog.component';

describe('LinksModalDialogComponent', () => {
  let component: LinksModalDialogComponent;
  let fixture: ComponentFixture<LinksModalDialogComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ LinksModalDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinksModalDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
