import { TestBed } from '@angular/core/testing';

import { AgnosticRepresentationService } from './agnostic-representation.service';

describe('AgnosticRepresentationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AgnosticRepresentationService = TestBed.get(AgnosticRepresentationService);
    expect(service).toBeTruthy();
  });
});
