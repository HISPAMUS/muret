import { TestBed } from '@angular/core/testing';

import { DocumentAnalysisService } from './document-analysis.service';

describe('DocumentAnalysisService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DocumentAnalysisService = TestBed.get(DocumentAnalysisService);
    expect(service).toBeTruthy();
  });
});
