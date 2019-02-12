import { TestBed } from '@angular/core/testing';

import { SessionDataService } from './services/session-data.service';

describe('SessionDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SessionDataService = TestBed.get(SessionDataService);
    expect(service).toBeTruthy();
  });
});
