import { TestBed } from '@angular/core/testing';

import { SymbolCrudService } from './symbol-crud.service';

describe('SymbolCrudService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SymbolCrudService = TestBed.get(SymbolCrudService);
    expect(service).toBeTruthy();
  });
});
