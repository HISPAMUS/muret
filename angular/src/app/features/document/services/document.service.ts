import { Injectable } from '@angular/core';
import {Document} from '../../../core/model/entities/document';
import {Observable} from 'rxjs';
import {Image} from '../../../core/model/entities/image';
import {ApiRestClientService} from '../../../core/services/api-rest-client.service';
import {StringResponse} from '../../../core/model/restapi/string-response';
import {DocumentStatistics} from '../../../core/model/restapi/document-statistics';
import {PreflightCheckResult} from '../../../core/model/restapi/preflight-check-result';
import {AlignmentPreview} from '../../../core/model/restapi/alignment-preview';
import {Section} from "../../../core/model/entities/section";
import {SectionImages} from "../../../core/model/restapi/section-images";

@Injectable() // non-singleton
export class DocumentService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  public getOverview$(documentID: number): Observable<Document> {
    return this.apiRestClientService.getProjectionOf$<Document>(documentID, 'documents', 'overview');
  }

  moveImagesToSection$(sectionImages: SectionImages): Observable<SectionImages> {
    const url = `document/moveImagesToSection`;
    return this.apiRestClientService.put$(url, sectionImages);
  }
  /*public getParts$(documentID: number): Observable<Section[]> {
    return this.apiRestClientService.getDetailsExcerptProjection$<Section>('documents', 'parts', documentID);
  }*/

  // revisado hasta aquí

  public getDocument$(id: number): Observable<Document> {
    // return this.apiRestClientService.getOf$<Document>('documents', id);
    return this.apiRestClientService.getExcerptProjectionOf$<Document>(id, 'documents');
  }

  public getDocumentImages$(id: number): Observable<Image[]> {
    return this.apiRestClientService.getDetailsExcerptProjection$<Image>('documents', 'images', id);
  }

  public getDocumentStatistics$(id: number): Observable<DocumentStatistics> {
    const url = `document/statistics/${id}`;
    return this.apiRestClientService.get$<DocumentStatistics>(url);
  }
  public getDocumentUploadURL(): string {
    return this.apiRestClientService.url + '/document/uploadDocumentImages';
  }

  exportMEIPartsFacsimile$(documentID: number, selectedImages: Array<number>, forMeasuringPolyphony: boolean) {
    const selectedImagesString = selectedImages.join(',');
    let url: string;
    if (forMeasuringPolyphony) {
      url = `document/exportMeasuringPolyphony/${documentID}/${selectedImagesString}`;
    } else {
      url = `document/exportMEIPartsFacsimile/${documentID}/${selectedImagesString}`;
    }
    return this.apiRestClientService.get$<StringResponse>(url);
  }

  exportMEI$(documentID: number, partID: number, selectedImages: Array<number>): Observable<StringResponse> {
    const selectedImagesString = selectedImages.join(',');
    let url: string;
    if (partID) {
      url = `document/exportPartMEI/${documentID}/${partID}/${selectedImagesString}`;
    } else {
      url = `document/exportFullScoreMEI/${documentID}/${selectedImagesString}`;
    }
    return this.apiRestClientService.get$<StringResponse>(url);
  }

  exportMensurstrich$(documentID: number, selectedImages: Array<number>): Observable<Blob> {
    const selectedImagesString = selectedImages.join(',');
    const url = `document/exportMensurstrich/${documentID}/${selectedImagesString}`;
    return this.apiRestClientService.getBlob$(url);
  }

  exportMusicXML$(documentID: number, selectedImages: Array<number>): Observable<Blob> {
    const selectedImagesString = selectedImages.join(',');
    const url = `document/exportMusicXML/${documentID}/${selectedImagesString}`;
    return this.apiRestClientService.getBlob$(url);
  }

 /* preflightCheck$(documentID: number, selectedImages: Array<number>): Observable<PreflightCheckResult> {
    const selectedImagesString = selectedImages.join(',');
    const url = `document/preflightCheck/${documentID}/${selectedImagesString}`;
    return this.apiRestClientService.get$<PreflightCheckResult>(url);
  }*/

  getAlignmentPreview$(documentID: number): Observable<AlignmentPreview> {
    const url = `alignment/preview/${documentID}`;
    return this.apiRestClientService.get$<AlignmentPreview>(url);
  }


}
