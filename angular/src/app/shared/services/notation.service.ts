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
  breaks: 'encoded',
  noJustification: 1,
  pageWidth: 60000
};

const optionsPAEC = {
  breaks: 'encoded'
};


//TODO Values por Verovio

@Injectable()
export class NotationService {
  private vrvToolkit: any;

  constructor() {
    this.vrvToolkit = new verovio.toolkit();
  }

  public renderStaff(mei: string): string {
    //return this.vrvToolkit.RenderToPAE(mei, optionsStaff);
    return this.vrvToolkit.renderData(mei, optionsStaff);
  }

  public renderStaffToPAE(mei: string): string {
    this.vrvToolkit.loadData(mei);
    try {
      const result = this.vrvToolkit.renderToPAE();
      return result;
    } catch (e) {
      console.log(e);
      return 'Cannot convert to to PAEC';
    }
  }

  public renderScore(mei: string): string {
    return this.vrvToolkit.renderData(mei, optionsScore);
  }
}
