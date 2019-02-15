import { TestBed } from '@angular/core/testing';

import { RegionTypesCrudService } from './region-types-crud.service';

describe('RegionTypesCrudService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegionTypesCrudService = TestBed.get(RegionTypesCrudService);
    expect(service).toBeTruthy();
  });
});
