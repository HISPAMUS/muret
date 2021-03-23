import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DocumentScoreViewerAndExporterComponentOLD } from './document-score-viewer-and-exporter-component-o-l-d.component';

describe('DocumentScoreViewerComponent', () => {
  let component: DocumentScoreViewerAndExporterComponentOLD;
  let fixture: ComponentFixture<DocumentScoreViewerAndExporterComponentOLD>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentScoreViewerAndExporterComponentOLD ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentScoreViewerAndExporterComponentOLD);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
