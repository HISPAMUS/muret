import { TestBed } from '@angular/core/testing';

import { SvgCanvasStateService } from './svg-canvas-state.service';

describe('SvgCanvasStateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SvgCanvasStateService = TestBed.get(SvgCanvasStateService);
    expect(service).toBeTruthy();
  });
});
