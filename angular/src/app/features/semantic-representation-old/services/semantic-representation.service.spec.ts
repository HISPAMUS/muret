import { TestBed } from '@angular/core/testing';

import { SemanticRepresentationService } from './semantic-representation.service';

describe('SemanticRepresentationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SemanticRepresentationService = TestBed.get(SemanticRepresentationService);
    expect(service).toBeTruthy();
  });
});
