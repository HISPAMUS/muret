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
import {PartsInImage} from "../../../core/model/restapi/parts-in-image";
import {NumberArray} from "../../../core/model/restapi/number-array";
import {ImagesInNewPart} from "../../../core/model/restapi/images-in-new-part";
import {ImagesVisibility} from "../../../core/model/restapi/images-visibility";

@Injectable() // non-singleton
export class DocumentService {

  constructor(private apiRestClientService: ApiRestClientService) { }

  getOpen$(documentID) {
    const url = `document/logOpen/${documentID}`;
    return this.apiRestClientService.get$(url);
  }


  public getOverview$(documentID: number): Observable<Document> {
    return this.apiRestClientService.getProjectionOf$<Document>(documentID, 'documents', 'overview');
  }

  moveImagesToSection$(sectionImages: SectionImages): Observable<SectionImages> {
    const url = `document/moveImagesToSection`;
    return this.apiRestClientService.put$(url, sectionImages);
  }

  moveImagesToDefaultSection$(documentID: number): Observable<Section> {
    const url = `document/moveImagesToDefaultSection/${documentID}`;
    return this.apiRestClientService.put$(url, null);
  }

  createSection$(documentID: number, name: string): Observable<Section> {
    const url = `document/createSection/${documentID}/${name}`;
    return this.apiRestClientService.put$(url, null);
  }

  renameSection$(section: Section): Observable<Section> {
    const url = `document/renameSection/${section.id}/${section.name}`;
    return this.apiRestClientService.put$(url, null);
  }

  deleteSection$(sectionID: number): Observable<number> {
    const url = `document/deleteSection`;
    return this.apiRestClientService.delete$(url, sectionID);
  }

  /**
   * Returns the applied sectionIDsOrdering in the document
   * @param sectionIDsOrdering
   */
  reorderSections$(ordering: NumberArray): Observable<NumberArray> {
    const url = `document/reorderSections`;
    return this.apiRestClientService.put$(url, ordering);
  }

  getSection$(id: number): Observable<Section> {
    return this.apiRestClientService.getExcerptProjectionOf$(id, 'sections')
  }

  /**
   * Returns the applied sectionIDsOrdering in the document
   * @param sectionIDsOrdering
   */
  reorderImages$(ordering: NumberArray): Observable<NumberArray> {
    const url = `document/reorderImages`;
    return this.apiRestClientService.put$(url, ordering);
  }

  getPartsInImages$(documentID: number): Observable<PartsInImage[]> {
    const url = `document/partsInImages/${documentID}`;
    return this.apiRestClientService.get$<PartsInImage[]>(url);
  }

  linkImagesToPart$(imageIDs: NumberArray, partID: number): Observable<PartsInImage[]> {
    const url = `document/linkImagesToPart/${partID}`;
    return this.apiRestClientService.put$<PartsInImage[]>(url, imageIDs);
  }

  linkImagesToNewPart$(imageIDs: NumberArray, partName: string): Observable<ImagesInNewPart> {
    const url = `document/linkImagesToNewPart/${partName}`;
    return this.apiRestClientService.post$<ImagesInNewPart>(url, imageIDs);
  }

  unlinkImagesFromPart$(imageIDs: NumberArray): Observable<PartsInImage[]> {
    const url = `document/unlinkImagesFromPart`;
    return this.apiRestClientService.put$<PartsInImage[]>(url, imageIDs);
  }


  changeImagesVisibility$(imageIDs: NumberArray, hidden: boolean): Observable<ImagesVisibility> {
    const url = `document/changeImagesVisibility`;
    const iv: ImagesVisibility = {
      imageIDS: imageIDs,
      hidden: hidden
    };
    return this.apiRestClientService.put$<ImagesVisibility>(url, iv);
  }

  /*public getParts$(documentID: number): Observable<Section[]> {
    return this.apiRestClientService.getDetailsExcerptProjection$<Section>('documents', 'parts', documentID);
  }*/

  exportMEIPartsFacsimile$(selectedImages: NumberArray, forMeasuringPolyphony: boolean) {
    let url: string;
    if (forMeasuringPolyphony) {
      url = `document/exportMeasuringPolyphony`;
    } else {
      url = `document/exportMEIPartsFacsimile`;
    }
    return this.apiRestClientService.post$<StringResponse>(url, selectedImages);
  }

  exportMEI$(optionalPartID: number, selectedImages: NumberArray): Observable<StringResponse> {
    let url: string;
    if (optionalPartID) {
      url = `document/exportPartMEI/${optionalPartID}`;
    } else {
      url = `document/exportFullScoreMEI`;
    }
    return this.apiRestClientService.post$<StringResponse>(url, selectedImages);
  }

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
