import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Document} from "../../../../core/model/entities/document";
import {Image} from "../../../../core/model/entities/image";

interface ImageTableRow { // view of the image in the table
  sectionName: string;
  id: number;
  filename: string;
  documentAnalysisProgress: string;
  partsProgress: string;
  transcriptionProgress: string;
}

@Component({
  selector: 'app-images-table',
  templateUrl: './images-table.component.html',
  styleUrls: ['./images-table.component.css']
})
export class ImagesTableComponent implements OnInit, OnChanges {
  @Input() document: Document;
  imageRows: ImageTableRow[];

  constructor() { }

  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.imageRows = [];
    if (changes.document && this.document) {
      this.loadImages('Default section', this.document.images);
      if (this.document.sections) {
        this.document.sections.forEach(section => {
          this.loadImages(section.name, this.document.images);
        });
      }
    }
  }

  private loadImages(sectionName: string, images: Image[]) {
    images.forEach(image => {
      let documentAnalysisProgress = '-';
      let partsProgress = '-';
      let transcriptionProgress = '-';
      if (image.imageRecognitionProgressStatuses) {
        image.imageRecognitionProgressStatuses.forEach(progress => {
          switch (progress.phase) {
            case 'documentAnalysis':
              documentAnalysisProgress = progress.status;
              break;
            case 'parts':
              partsProgress = progress.status;
              break;
            case 'transcription':
              transcriptionProgress = progress.status;
              break;
            default:
              throw new Error('Unknown phase: "' + progress.phase + '"');
          }
        });
      }

      const row: ImageTableRow = {
        sectionName: sectionName,
        id: image.id,
        filename: image.filename,
        documentAnalysisProgress: documentAnalysisProgress,
        partsProgress: partsProgress,
        transcriptionProgress: transcriptionProgress
      }
      this.imageRows.push(row);
    });
  }

  imageTracking(index, item): number {
    return index;
  }



}
