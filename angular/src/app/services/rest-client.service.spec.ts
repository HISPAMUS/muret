import { TestBed } from '@angular/core/testing';

import { RestClientService } from './rest-client.service';

describe('ProjectService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RestClientService = TestBed.get(RestClientService);
    expect(service).toBeTruthy();
  });
});
