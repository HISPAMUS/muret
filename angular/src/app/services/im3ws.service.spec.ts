import { TestBed } from '@angular/core/testing';

import { Im3wsService } from './im3ws.service';

describe('ProjectService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Im3wsService = TestBed.get(Im3wsService);
    expect(service).toBeTruthy();
  });
});
