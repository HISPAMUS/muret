import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {map, switchMap} from 'rxjs/operators';
import {PartsService} from '../../services/parts.service';
import {
  CreateImagePart,
  CreateImagePartSuccess,
  CreatePagePart,
  CreatePagePartSuccess,
  CreateRegionPart,
  CreateRegionPartSuccess,
  CreateSymbolPart, CreateSymbolPartSuccess,
  GetImagePart,
  GetImagePartSuccess, GetImageProjectParts, GetImageProjectPartsSuccess,
  GetPagePart,
  GetPagePartSuccess, GetProjectParts, GetProjectPartsSuccess,
  GetRegionPart,
  GetRegionPartSuccess,
  GetSymbolPart,
  GetSymbolPartSuccess,
  PartsActionTypes,
  UpdateImagePart,
  UpdateImagePartSuccess,
  UpdatePagePart,
  UpdatePagePartSuccess,
  UpdateRegionPart,
  UpdateRegionPartSuccess,
  UpdateSymbolPart,
  UpdateSymbolPartSuccess
} from '../actions/parts.actions';
import {Part} from '../../../../core/model/entities/part';
import {Image} from '../../../../core/model/entities/image';
import {Page} from '../../../../core/model/entities/page';
import {Region} from '../../../../core/model/entities/region';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';

@Injectable()
export class PartsEffects {
  constructor(
    private partsService: PartsService,
    private actions$: Actions,
  ) {}

  @Effect()
  getProjectParts$ = this.actions$.pipe(
    ofType<GetProjectParts>(PartsActionTypes.GetProjectParts),
    map((action: GetProjectParts) => action),
    switchMap((action) => this.partsService.getProjectParts$(action.projectID)),
    switchMap((parts: Part[]) => {
      return of(new GetProjectPartsSuccess(parts));
    })
  );

  @Effect()
  getImageProjectParts$ = this.actions$.pipe(
    ofType<GetImageProjectParts>(PartsActionTypes.GetImageProjectParts),
    map((action: GetImageProjectParts) => action),
    switchMap((action) => this.partsService.getImageProjectParts$(action.imageID)),
    switchMap((parts: Part[]) => {
      return of(new GetImageProjectPartsSuccess(parts));
    })
  );
  @Effect()
  getImagePart$ = this.actions$.pipe(
    ofType<GetImagePart>(PartsActionTypes.GetImagePart),
    map((action: GetImagePart) => action),
    switchMap((action) => this.partsService.getImagePart$(action.image.id)),
    switchMap((part: Part) => {
      return of(new GetImagePartSuccess(part));
    })
  );

  @Effect()
  updateImagePart$ = this.actions$.pipe(
    ofType<UpdateImagePart>(PartsActionTypes.UpdateImagePart),
    switchMap((action: UpdateImagePart) =>
      this.partsService.updateImagePart$(action.image, action.part)),
    switchMap((part: Part) => {
      return of(new UpdateImagePartSuccess(part));
    })
  );

  @Effect()
  getPagePart$ = this.actions$.pipe(
    ofType<GetPagePart>(PartsActionTypes.GetPagePart),
    map((action: GetPagePart) => action),
    switchMap((action) => this.partsService.getPagePart$(action.page.id)),
    switchMap((part: Part) => {
      return of(new GetPagePartSuccess(part));
    })
  );

  @Effect()
  updatePagePart$ = this.actions$.pipe(
    ofType<UpdatePagePart>(PartsActionTypes.UpdatePagePart),
    switchMap((action: UpdatePagePart) =>
      this.partsService.updatePagePart$(action.page, action.part)),
    switchMap((part: Part) => {
      return of(new UpdatePagePartSuccess(part));
    })
  );

  @Effect()
  getRegionPart$ = this.actions$.pipe(
    ofType<GetRegionPart>(PartsActionTypes.GetRegionPart),
    map((action: GetRegionPart) => action),
    switchMap((action) => this.partsService.getRegionPart$(action.region.id)),
    switchMap((part: Part) => {
      return of(new GetRegionPartSuccess(part));
    })
  );

  @Effect()
  updateRegionPart$ = this.actions$.pipe(
    ofType<UpdateRegionPart>(PartsActionTypes.UpdateRegionPart),
    switchMap((action: UpdateRegionPart) =>
      this.partsService.updateRegionPart$(action.region, action.part)),
    switchMap((part: Part) => {
      return of(new UpdateRegionPartSuccess(part));
    })
  );

  @Effect()
  getSymbolPart$ = this.actions$.pipe(
    ofType<GetSymbolPart>(PartsActionTypes.GetSymbolPart),
    map((action: GetSymbolPart) => action),
    switchMap((action) => this.partsService.getSymbolPart$(action.symbol.id)),
    switchMap((part: Part) => {
      return of(new GetSymbolPartSuccess(part));
    })
  );

  @Effect()
  updateSymbolPart$ = this.actions$.pipe(
    ofType<UpdateSymbolPart>(PartsActionTypes.UpdateSymbolPart),
    switchMap((action: UpdateSymbolPart) =>
      this.partsService.updateSymbolPart$(action.symbol, action.part)),
    switchMap((part: Part) => {
      return of(new UpdateSymbolPartSuccess(part));
    })
  );

  @Effect()
  createImagePart$ = this.actions$.pipe(
    ofType<CreateImagePart>(PartsActionTypes.CreateImagePart),
    switchMap((action: CreateImagePart) =>
      this.partsService.createImagePart$(action.image, action.partName)),
    switchMap((part: Part) => {
      return of(new CreateImagePartSuccess(part));
    })
  );

  @Effect()
  createPagePart$ = this.actions$.pipe(
    ofType<CreatePagePart>(PartsActionTypes.CreatePagePart),
    switchMap((action: CreatePagePart) =>
      this.partsService.createPagePart$(action.page, action.partName)),
    switchMap((part: Part) => {
      return of(new CreatePagePartSuccess(part));
    })
  );

  @Effect()
  createRegionPart$ = this.actions$.pipe(
    ofType<CreateRegionPart>(PartsActionTypes.CreateRegionPart),
    switchMap((action: CreateRegionPart) =>
      this.partsService.createRegionPart$(action.region, action.partName)),
    switchMap((part: Part) => {
      return of(new CreateRegionPartSuccess(part));
    })
  );

  @Effect()
  createSymbolPart$ = this.actions$.pipe(
    ofType<CreateSymbolPart>(PartsActionTypes.CreateSymbolPart),
    switchMap((action: CreateSymbolPart) =>
      this.partsService.createSymbolPart$(action.symbol, action.partName)),
    switchMap((part: Part) => {
      return of(new CreateSymbolPartSuccess(part));
    })
  );
}