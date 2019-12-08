import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {ProjectService} from '../../services/project.service';
import {
  ExportMEI, ExportMEIPartsFacsimile, ExportMEIPartsFacsimileSuccess,
  ExportMEISuccess, ExportMensurstrich, ExportMensurstrichSuccess, ExportMusicXML, ExportMusicXMLSuccess,
  GetImages,
  GetImagesSuccess, GetUsesOfParts, GetUsesOfPartsSuccess,
  GetProject, GetProjectStatistics, GetProjectStatisticsSuccess,
  GetProjectSuccess,
  ProjectActionTypes
} from '../actions/project.actions';
import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';
import {StringResponse} from '../../../../core/model/restapi/string-response';
import {ProjectStatistics} from '../../../../core/model/restapi/project-statistics';
import {PartUses, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

@Injectable()
export class ProjectEffects {
  constructor(
    private projectService: ProjectService,
    private actions$: Actions,
  ) {}

  @Effect()
  getProject$ = this.actions$.pipe(
    ofType<GetProject>(ProjectActionTypes.GetProject),
    map((action: GetProject) => action.projectID),
    switchMap((projectID) => this.projectService.getProject$(projectID)),
    switchMap((project: Project) => {
      return of(new GetProjectSuccess(project));
    })
  );

  @Effect()
  getImages$ = this.actions$.pipe(
    ofType<GetImages>(ProjectActionTypes.GetImages),
    map((action: GetImages) => action.projectID),
    switchMap((projectID) => this.projectService.getProjectImages$(projectID)),
    switchMap((images: Image[]) => {
      return of(new GetImagesSuccess(images));
    })
  );

  @Effect()
  exportMEIPartsFacsimile$ = this.actions$.pipe(
    ofType<ExportMEIPartsFacsimile>(ProjectActionTypes.ExportMEIPartsFacsimile),
    switchMap((action: ExportMEIPartsFacsimile) => this.projectService.exportMEIPartsFacsimile$(action.projectID)),
    switchMap((mei: StringResponse) => {
      return of(new ExportMEIPartsFacsimileSuccess(mei.response));
    })
  );

  @Effect()
  exportMEI$ = this.actions$.pipe(
    ofType<ExportMEI>(ProjectActionTypes.ExportMEI),
    switchMap((action: ExportMEI) => this.projectService.exportMEI$(action.projectID, action.partID)),
    switchMap((mei: StringResponse) => {
      return of(new ExportMEISuccess(mei.response));
    })
  );

  @Effect()
  exportMensurstrich$ = this.actions$.pipe(
    ofType<ExportMensurstrich>(ProjectActionTypes.ExportMensurstrich),
    switchMap((action: ExportMensurstrich) => this.projectService.exportMensurstrich$(action.projectID)),
    switchMap((payload: Blob) => {
      return of(new ExportMensurstrichSuccess(payload));
    })
  );
  @Effect()
  exportMusicXML$ = this.actions$.pipe(
    ofType<ExportMusicXML>(ProjectActionTypes.ExportMusicXML),
    switchMap((action: ExportMusicXML) => this.projectService.exportMusicXML$(action.projectID)),
    switchMap((payload: Blob) => {
      return of(new ExportMusicXMLSuccess(payload));
    })
  );

  @Effect()
  getProjectStatistics$ = this.actions$.pipe(
    ofType<GetProjectStatistics>(ProjectActionTypes.GetProjectStatistics),
    map((action: GetProjectStatistics) => action.projectID),
    switchMap((projectID) => this.projectService.getProjectStatistics$(projectID)),
    switchMap((projectStatistics: ProjectStatistics) => {
      return of(new GetProjectStatisticsSuccess(projectStatistics));
    })
  );

  @Effect()
  getUsesOfParts$ = this.actions$.pipe(
    ofType<GetUsesOfParts>(ProjectActionTypes.GetUsesOfParts),
    map((action: GetUsesOfParts) => action.partID),
    switchMap((partID) => this.projectService.getUsesOfParts$(partID)),
    switchMap((usesOfParts: UsesOfParts) => {
      return of(new GetUsesOfPartsSuccess(usesOfParts));
    })
  );
}
