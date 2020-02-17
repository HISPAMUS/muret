import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import {Observable, of} from 'rxjs';
import {catchError, switchMap} from 'rxjs/operators';
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
  DocumentActionTypes,
  GetAlignmentPreview,
  GetAlignmentPreviewSuccess, DocumentServerError,
} from '../actions/document.actions';
import {Document} from '../../../../core/model/entities/document';
import {Image} from '../../../../core/model/entities/image';
import {StringResponse} from '../../../../core/model/restapi/string-response';
import {DocumentStatistics} from '../../../../core/model/restapi/document-statistics';
import {AlignmentPreview} from '../../../../core/model/restapi/alignment-preview';
import {ImageFilesService} from '../../../../core/services/image-files.service';
import {Action} from '@ngrx/store';

@Injectable()
export class DocumentEffects {
  constructor(
    private documentService: DocumentService,
    private imageFilesService: ImageFilesService,
    private actions$: Actions,
  ) {}

  @Effect()
  getDocument$: Observable<Action> = this.actions$.pipe(
    ofType<GetDocument>(DocumentActionTypes.GetDocument),
    switchMap((action: GetDocument) => this.documentService.getDocument$(action.documentID).pipe(
      switchMap((document: Document) => of(new GetDocumentSuccess(document))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getImages$: Observable<Action> = this.actions$.pipe(
    ofType<GetImages>(DocumentActionTypes.GetImages),
    switchMap((action: GetImages) => this.documentService.getDocumentImages$(action.documentID).pipe(
      switchMap((images: Image[]) => of(new GetImagesSuccess(images))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMEIPartsFacsimile$: Observable<Action> = this.actions$.pipe(
    ofType<ExportMEIPartsFacsimile>(DocumentActionTypes.ExportMEIPartsFacsimile),
    switchMap((action: ExportMEIPartsFacsimile) =>
      this.documentService.exportMEIPartsFacsimile$(action.documentID, action.selectedImages).pipe(
        switchMap((mei: StringResponse) => of(new ExportMEIPartsFacsimileSuccess(mei.response))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMEI$: Observable<Action> = this.actions$.pipe(
    ofType<ExportMEI>(DocumentActionTypes.ExportMEI),
    switchMap((action: ExportMEI) => this.documentService.exportMEI$(action.documentID, action.partID, action.selectedImages).pipe(
      switchMap((mei: StringResponse) => of(new ExportMEISuccess(mei.response))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMensurstrich$: Observable<Action> = this.actions$.pipe(
    ofType<ExportMensurstrich>(DocumentActionTypes.ExportMensurstrich),
    switchMap((action: ExportMensurstrich) => this.documentService.exportMensurstrich$(action.documentID, action.selectedImages).pipe(
      switchMap((payload: Blob) => of(new ExportMensurstrichSuccess(payload))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  exportMusicXML$: Observable<Action> = this.actions$.pipe(
    ofType<ExportMusicXML>(DocumentActionTypes.ExportMusicXML),
    switchMap((action: ExportMusicXML) => this.documentService.exportMusicXML$(action.documentID, action.selectedImages).pipe(
      switchMap((payload: Blob) => of(new ExportMusicXMLSuccess(payload))),
      catchError(err => of(new DocumentServerError(err)))
    )));

  @Effect()
  getDocumentStatistics$: Observable<Action> = this.actions$.pipe(
    ofType<GetDocumentStatistics>(DocumentActionTypes.GetDocumentStatistics),
    switchMap((action: GetDocumentStatistics) => this.documentService.getDocumentStatistics$(action.documentID).pipe(
      switchMap((documentStatistics: DocumentStatistics) => of(new GetDocumentStatisticsSuccess(documentStatistics))),
      catchError(err => of(new DocumentServerError(err)))
    )));
  /**
   * @deprecated Use getAlignmentPreview$
   */
 /* @Effect()
  preflightCheck$ = this.actions$.pipe(
    ofType<PreflightCheck>(DocumentActionTypes.PreflightCheck),
    switchMap((action: PreflightCheck) => this.documentService.preflightCheck$(action.documentID, action.selectedImages)),
    switchMap((preflightCheckResult: PreflightCheckResult) => {
      return of(new PreflightCheckSuccess(preflightCheckResult));
    })
  );*/

  @Effect()
  getAlignmentPreview$: Observable<Action> = this.actions$.pipe(
    ofType<GetAlignmentPreview>(DocumentActionTypes.GetAlignmentPreview),
    switchMap((action: GetAlignmentPreview) => this.documentService.getAlignmentPreview$(action.documentID).pipe(
      switchMap((alignmentPreview: AlignmentPreview) => of(new GetAlignmentPreviewSuccess(alignmentPreview))),
      catchError(err => of(new DocumentServerError(err)))
    )));
}
