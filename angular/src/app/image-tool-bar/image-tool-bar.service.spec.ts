import { TestBed } from '@angular/core/testing';

import { ImageToolBarService } from './image-tool-bar.service';

describe('ImageToolBarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ImageToolBarService = TestBed.get(ImageToolBarService);
    expect(service).toBeTruthy();
  });
});
