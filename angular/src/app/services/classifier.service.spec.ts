import { TestBed } from '@angular/core/testing';

import { ClassifierService } from './classifier.service';

describe('ClassifierService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClassifierService = TestBed.get(ClassifierService);
    expect(service).toBeTruthy();
  });
});
