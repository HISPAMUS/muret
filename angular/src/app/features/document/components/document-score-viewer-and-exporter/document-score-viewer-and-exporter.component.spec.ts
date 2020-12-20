import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DocumentScoreViewerAndExporterComponent } from './document-score-viewer-and-exporter.component';

describe('DocumentScoreViewerComponent', () => {
  let component: DocumentScoreViewerAndExporterComponent;
  let fixture: ComponentFixture<DocumentScoreViewerAndExporterComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentScoreViewerAndExporterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentScoreViewerAndExporterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
