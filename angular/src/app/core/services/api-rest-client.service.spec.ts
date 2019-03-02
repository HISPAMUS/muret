import { TestBed } from '@angular/core/testing';

import { ApiRestClientService } from './api-rest-client.service';

describe('ApiRestClientService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiRestClientService = TestBed.get(ApiRestClientService);
    expect(service).toBeTruthy();
  });
});
