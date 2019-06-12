import { Injectable } from '@angular/core';

declare var verovio: any;

const options = {
  scale: 100,
  adjustPageHeight: 1,
  breaks: 'encoded',
  noJustification: 1,
  spacingDurDetection: 1,
  evenNoteSpacing: 1
};

@Injectable()
export class NotationService {
  private vrvToolkit: any;

  constructor() {
    this.vrvToolkit = new verovio.toolkit();
  }

  public render(mei: string): string {
    return this.vrvToolkit.renderData(mei, options);
  }
}
