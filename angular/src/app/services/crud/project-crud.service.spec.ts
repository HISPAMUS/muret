import { TestBed } from '@angular/core/testing';

import { ProjectCrudService } from './project-crud.service';

describe('ProjectCrudService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProjectCrudService = TestBed.get(ProjectCrudService);
    expect(service).toBeTruthy();
  });
});
