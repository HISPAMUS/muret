import { TestBed } from '@angular/core/testing';

import { ServerStatusService } from './server-status.service';

describe('ServerStatusService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServerStatusService = TestBed.get(ServerStatusService);
    expect(service).toBeTruthy();
  });
});
