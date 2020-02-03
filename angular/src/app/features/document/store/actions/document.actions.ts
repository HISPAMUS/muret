import { Action } from '@ngrx/store';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {PreflightCheckResult} from '../../../../core/model/restapi/preflight-check-result';

export enum DocumentActionTypes {
  GetDocument = '[Document] Get document',
  GetDocumentSuccess = '[Document] Get document success',
  GetImages = '[Document] Get images',
  GetImagesSuccess = '[Document] Get images success',
  ExportMEI = '[Document] Export MEI',
  ExportMEISuccess = '[Document] Export MEI success',
  ExportMEIPartsFacsimile = '[Document] Export MEI parts and facsimile',
  ExportMEIPartsFacsimileSuccess = '[Document] Export MEI parts and facsimile success',
  ExportMensurstrich = '[Document] Export mensurstrich',
  ExportMensurstrichSuccess = '[Document] Export mensurstrich success',
  ExportMusicXML = '[Document] Export MusicXML',
  ExportMusicXMLSuccess = '[Document] Export MusicXML success',
  GetDocumentStatistics = '[Document] Get document statistics',
  GetDocumentStatisticsSuccess = '[Document] Get document statistics success',
  PreflightCheck = '[Document] Preflight check',
  PreflightCheckSuccess = '[Document] Preflight check success',
}

export class GetDocument implements Action {
  public readonly type = DocumentActionTypes.GetDocument;
  constructor(public documentID: number) {}
}

export class GetDocumentSuccess implements Action {
  public readonly type = DocumentActionTypes.GetDocumentSuccess;
  constructor(public document: Document) {}
}

export class GetImages implements Action {
  public readonly type = DocumentActionTypes.GetImages;
  constructor(public documentID: number) {}
}

export class GetImagesSuccess implements Action {
  public readonly type = DocumentActionTypes.GetImagesSuccess;
  constructor(public images: Image[]) {}
}

export class ExportMEI implements Action {
  public readonly type = DocumentActionTypes.ExportMEI;
  constructor(public documentID: number, public partID: number, public selectedImages: Array<number>) {}
}

export class ExportMEISuccess implements Action {
  public readonly type = DocumentActionTypes.ExportMEISuccess;
  constructor(public mei: string) {}
}

export class ExportMEIPartsFacsimile implements Action {
  public readonly type = DocumentActionTypes.ExportMEIPartsFacsimile;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class ExportMEIPartsFacsimileSuccess implements Action {
  public readonly type = DocumentActionTypes.ExportMEIPartsFacsimileSuccess;
  constructor(public mei: string) {}
}

export class ExportMensurstrich implements Action {
  public readonly type = DocumentActionTypes.ExportMensurstrich;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class ExportMensurstrichSuccess implements Action {
  public readonly type = DocumentActionTypes.ExportMensurstrichSuccess;
  constructor(public payload: Blob) {}
}

export class ExportMusicXML implements Action {
  public readonly type = DocumentActionTypes.ExportMusicXML;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class ExportMusicXMLSuccess implements Action {
  public readonly type = DocumentActionTypes.ExportMusicXMLSuccess;
  constructor(public payload: Blob) {}
}

export class GetDocumentStatistics implements Action {
  public readonly type = DocumentActionTypes.GetDocumentStatistics;
  constructor(public documentID: number) {}
}

export class GetDocumentStatisticsSuccess implements Action {
  public readonly type = DocumentActionTypes.GetDocumentStatisticsSuccess;
  constructor(public documentStatistics: DocumentStatistics) {}
}

export class PreflightCheck implements Action {
  public readonly type = DocumentActionTypes.PreflightCheck;
  constructor(public documentID: number, public selectedImages: Array<number>) {}
}

export class PreflightCheckSuccess implements Action {
  public readonly type = DocumentActionTypes.PreflightCheckSuccess;
  constructor(public preflightCheckResult: PreflightCheckResult[]) {}
}


export type DocumentActions =
  GetDocument | GetDocumentSuccess | GetImages | GetImagesSuccess | ExportMEI | ExportMEISuccess |
  ExportMEIPartsFacsimile | ExportMEIPartsFacsimileSuccess |
  ExportMensurstrich | ExportMensurstrichSuccess |
  ExportMusicXML | ExportMusicXMLSuccess |
  GetDocumentStatistics | GetDocumentStatisticsSuccess |
  PreflightCheck | PreflightCheckSuccess;
