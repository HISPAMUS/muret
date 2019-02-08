import { TestBed } from '@angular/core/testing';

import { SymbolService } from './symbol.service';

describe('SymbolService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SymbolService = TestBed.get(SymbolService);
    expect(service).toBeTruthy();
  });
});
