import { TestBed } from '@angular/core/testing';

import { ClassifierCrudService } from './classifier-crud.service';

describe('ClassifierCrudService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClassifierCrudService = TestBed.get(ClassifierCrudService);
    expect(service).toBeTruthy();
  });
});
