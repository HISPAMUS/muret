import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {DocumentService} from '../../services/document.service';
import {
  ExportMEI,
  ExportMEIPartsFacsimile,
  ExportMEIPartsFacsimileSuccess,
  ExportMEISuccess,
  ExportMensurstrich,
  ExportMensurstrichSuccess,
  ExportMusicXML,
  ExportMusicXMLSuccess,
  GetImages,
  GetImagesSuccess,
  GetDocument,
  GetDocumentStatistics,
  GetDocumentStatisticsSuccess,
  GetDocumentSuccess,
  DocumentActionTypes, PreflightCheck, PreflightCheckSuccess,
} from '../actions/document.actions';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {StringResponse} from '../../../../core/model/restapi/string-response';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {Collection} from '../../../../core/model/entities/collection';
import {PreflightCheckResult} from '../../../../core/model/restapi/preflight-check-result';

@Injectable()
export class DocumentEffects {
  constructor(
    private documentService: DocumentService,
    private actions$: Actions,
  ) {}

  @Effect()
  getDocument$ = this.actions$.pipe(
    ofType<GetDocument>(DocumentActionTypes.GetDocument),
    map((action: GetDocument) => action.documentID),
    switchMap((documentID) => this.documentService.getDocument$(documentID)),
    switchMap((document: Document) => {
      return of(new GetDocumentSuccess(document));
    })
  );

  @Effect()
  getImages$ = this.actions$.pipe(
    ofType<GetImages>(DocumentActionTypes.GetImages),
    map((action: GetImages) => action.documentID),
    switchMap((documentID) => this.documentService.getDocumentImages$(documentID)),
    switchMap((images: Image[]) => {
      return of(new GetImagesSuccess(images));
    })
  );

  @Effect()
  exportMEIPartsFacsimile$ = this.actions$.pipe(
    ofType<ExportMEIPartsFacsimile>(DocumentActionTypes.ExportMEIPartsFacsimile),
    switchMap((action: ExportMEIPartsFacsimile) => this.documentService.exportMEIPartsFacsimile$(action.documentID, action.selectedImages)),
    switchMap((mei: StringResponse) => {
      return of(new ExportMEIPartsFacsimileSuccess(mei.response));
    })
  );

  @Effect()
  exportMEI$ = this.actions$.pipe(
    ofType<ExportMEI>(DocumentActionTypes.ExportMEI),
    switchMap((action: ExportMEI) => this.documentService.exportMEI$(action.documentID, action.partID, action.selectedImages)),
    switchMap((mei: StringResponse) => {
      return of(new ExportMEISuccess(mei.response));
    })
  );

  @Effect()
  exportMensurstrich$ = this.actions$.pipe(
    ofType<ExportMensurstrich>(DocumentActionTypes.ExportMensurstrich),
    switchMap((action: ExportMensurstrich) => this.documentService.exportMensurstrich$(action.documentID, action.selectedImages)),
    switchMap((payload: Blob) => {
      return of(new ExportMensurstrichSuccess(payload));
    })
  );
  @Effect()
  exportMusicXML$ = this.actions$.pipe(
    ofType<ExportMusicXML>(DocumentActionTypes.ExportMusicXML),
    switchMap((action: ExportMusicXML) => this.documentService.exportMusicXML$(action.documentID, action.selectedImages)),
    switchMap((payload: Blob) => {
      return of(new ExportMusicXMLSuccess(payload));
    })
  );

  @Effect()
  getDocumentStatistics$ = this.actions$.pipe(
    ofType<GetDocumentStatistics>(DocumentActionTypes.GetDocumentStatistics),
    map((action: GetDocumentStatistics) => action.documentID),
    switchMap((documentID) => this.documentService.getDocumentStatistics$(documentID)),
    switchMap((documentStatistics: DocumentStatistics) => {
      return of(new GetDocumentStatisticsSuccess(documentStatistics));
    })
  );

  @Effect()
  preflightCheck$ = this.actions$.pipe(
    ofType<PreflightCheck>(DocumentActionTypes.PreflightCheck),
    switchMap((action: PreflightCheck) => this.documentService.preflightCheck$(action.documentID, action.selectedImages)),
    switchMap((preflightCheckResult: PreflightCheckResult[]) => {
      return of(new PreflightCheckSuccess(preflightCheckResult));
    })
  );
}
