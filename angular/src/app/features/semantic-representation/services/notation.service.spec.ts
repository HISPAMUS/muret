import { TestBed } from '@angular/core/testing';

import { NotationService } from './notation.service';

describe('NotationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NotationService = TestBed.get(NotationService);
    expect(service).toBeTruthy();
  });
});
