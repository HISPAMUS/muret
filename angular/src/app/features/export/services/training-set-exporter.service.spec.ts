import { TestBed } from '@angular/core/testing';

import { TrainingSetExporterService } from './training-set-exporter.service';

describe('TrainingSetExporterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TrainingSetExporterService = TestBed.get(TrainingSetExporterService);
    expect(service).toBeTruthy();
  });
});
