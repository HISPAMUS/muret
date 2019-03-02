import { TestBed } from '@angular/core/testing';

import { ExporterService } from './exporter.service';

describe('ExporterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ExporterService = TestBed.get(ExporterService);
    expect(service).toBeTruthy();
  });
});
