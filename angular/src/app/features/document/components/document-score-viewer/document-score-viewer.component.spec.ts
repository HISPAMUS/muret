import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentScoreViewerComponent } from './document-score-viewer.component';

describe('DocumentScoreViewerComponent', () => {
  let component: DocumentScoreViewerComponent;
  let fixture: ComponentFixture<DocumentScoreViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentScoreViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentScoreViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
