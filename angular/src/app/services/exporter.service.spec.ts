import { TestBed } from '@angular/core/testing';

import { TrainingSetService } from './training-set.service';

describe('TrainingSetService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TrainingSetService = TestBed.get(TrainingSetService);
    expect(service).toBeTruthy();
  });
});
