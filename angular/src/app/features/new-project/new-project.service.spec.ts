import { TestBed } from '@angular/core/testing';

import { NewProjectService } from './new-project.service';

describe('NewProjectService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NewProjectService = TestBed.get(NewProjectService);
    expect(service).toBeTruthy();
  });
});
