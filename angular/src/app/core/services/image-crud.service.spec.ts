import { TestBed } from '@angular/core/testing';

import { ImageFilesService } from './image-files.service';

describe('ImageFilesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ImageFilesService = TestBed.get(ImageFilesService);
    expect(service).toBeTruthy();
  });
});
