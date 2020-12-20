import { TestBed } from '@angular/core/testing';

import { PositionInStaffService } from './position-in-staff.service';

describe('PositionInStaffService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PositionInStaffService = TestBed.get(PositionInStaffService);
    expect(service).toBeTruthy();
  });
});
