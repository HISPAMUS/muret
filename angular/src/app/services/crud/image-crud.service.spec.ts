import { TestBed } from '@angular/core/testing';

import { ImageCrudService } from './image-crud.service';

describe('ImageCrudService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ImageCrudService = TestBed.get(ImageCrudService);
    expect(service).toBeTruthy();
  });
});
