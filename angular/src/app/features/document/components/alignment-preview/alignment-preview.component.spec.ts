import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlignmentPreviewComponent } from './alignment-preview.component';

describe('AlignmentPreviewComponent', () => {
  let component: AlignmentPreviewComponent;
  let fixture: ComponentFixture<AlignmentPreviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlignmentPreviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlignmentPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
