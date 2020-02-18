import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinksModalDialogComponent } from './links-modal-dialog.component';

describe('LinksModalDialogComponent', () => {
  let component: LinksModalDialogComponent;
  let fixture: ComponentFixture<LinksModalDialogComponent>;

  beforeEach(async(() => {
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
