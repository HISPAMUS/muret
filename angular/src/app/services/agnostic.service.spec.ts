import { TestBed } from '@angular/core/testing';

import { AgnosticService } from './agnostic.service';

describe('AgnosticService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AgnosticService = TestBed.get(AgnosticService);
    expect(service).toBeTruthy();
  });
});
