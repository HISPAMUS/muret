import { Injectable } from '@angular/core';

declare var verovio: any;

const optionsStaff = {
  scale: 100,
  adjustPageHeight: 1,
  breaks: 'encoded',
  noJustification: 1,
  spacingDurDetection: 1,
  evenNoteSpacing: 1
};

const optionsScore = {
  scale: 75,
  adjustPageHeight: 1,
  breaks: 'encoded'
};

@Injectable()
export class NotationService {
  private vrvToolkit: any;

  constructor() {
    this.vrvToolkit = new verovio.toolkit();
  }

  public renderStaff(mei: string): string {
    return this.vrvToolkit.renderData(mei, optionsStaff);
  }

  public renderScore(mei: string): string {
    return this.vrvToolkit.renderData(mei, optionsScore);
  }
}
