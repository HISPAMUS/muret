import { Injectable } from '@angular/core';
import { Effect, ofType, Actions } from '@ngrx/effects';
import { of } from 'rxjs';
import {catchError, map, switchMap} from 'rxjs/operators';
import {PartsService} from '../../services/parts.service';
import {
  CreateImagePart, CreateImagePartSuccess, CreatePagePart, CreatePagePartSuccess,
  CreatePart,
  CreatePartSuccess, CreateRegionPart, CreateRegionPartSuccess,
  DeletePart,
  DeletePartSuccess,
  GetUsesOfParts,
  GetUsesOfPartsSuccess,
  LinkPartToImage,
  LinkPartToImageSuccess,
  LinkPartToPage,
  LinkPartToPageSuccess,
  LinkPartToRegion,
  LinkPartToRegionSuccess,
  PartsActionTypes, PartsServerError,
  RenamePart,
  RenamePartSuccess,
  UnlinkPartToImage,
  UnlinkPartToImageSuccess,
  UnlinkPartToPage,
  UnlinkPartToPageSuccess, UnlinkPartToRegion, UnlinkPartToRegionSuccess,
} from '../actions/parts.actions';
import {Part} from '../../../../core/model/entities/part';
import {PartUse, UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';

@Injectable()
export class PartsEffects {
  constructor(
    private partsService: PartsService,
    private actions$: Actions,
  ) {}

  @Effect()
  createImagePart$ = this.actions$.pipe(
    ofType<CreateImagePart>(PartsActionTypes.CreateImagePart),
    switchMap((action: CreateImagePart) =>
      this.partsService.createImagePart$(action.imageId, action.partName).pipe(
    switchMap((partUse: PartUse) => of(new CreateImagePartSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));


  @Effect()
  createPagePart$ = this.actions$.pipe(
    ofType<CreatePagePart>(PartsActionTypes.CreatePagePart),
    switchMap((action: CreatePagePart) =>
      this.partsService.createPagePart$(action.pageId, action.partName).pipe(
    switchMap((partUse: PartUse) => of(new CreatePagePartSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  createRegionPart$ = this.actions$.pipe(
    ofType<CreateRegionPart>(PartsActionTypes.CreateRegionPart),
    switchMap((action: CreateRegionPart) =>
      this.partsService.createRegionPart$(action.regionId, action.partName).pipe(
    switchMap((partUse: PartUse) => of(new CreateRegionPartSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  /*@Effect()
  getDocumentParts$ = this.actions$.pipe(
    ofType<GetDocumentParts>(PartsActionTypes.GetDocumentParts),
    map((action: GetDocumentParts) => action),
    switchMap((action) => this.partsService.getDocumentParts$(action.documentID)),
    switchMap((parts: Part[]) => {
      return of(new GetDocumentPartsSuccess(parts));
    })
  );

  @Effect()
  getImageDocumentParts$ = this.actions$.pipe(
    ofType<GetImageDocumentParts>(PartsActionTypes.GetImageDocumentParts),
    map((action: GetImageDocumentParts) => action),
    switchMap((action) => this.partsService.getImageDocumentParts$(action.imageID)),
    switchMap((parts: Part[]) => {
      return of(new GetImageDocumentPartsSuccess(parts));
    })
  );*/


/*
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
  createSymbolPart$ = this.actions$.pipe(
    ofType<CreateSymbolPart>(PartsActionTypes.CreateSymbolPart),
    switchMap((action: CreateSymbolPart) =>
      this.partsService.createSymbolPart$(action.symbol, action.partName)),
    switchMap((part: Part) => {
      return of(new CreateSymbolPartSuccess(part));
    })
  );*/

  @Effect()
  renamePart$ = this.actions$.pipe(
    ofType<RenamePart>(PartsActionTypes.RenamePart),
    switchMap((action: RenamePart) =>
      this.partsService.renamePart$(action.part, action.newName).pipe(
    switchMap((part: Part) => of(new RenamePartSuccess(part))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  createPart$ = this.actions$.pipe(
    ofType<CreatePart>(PartsActionTypes.CreatePart),
    switchMap((action: CreatePart) =>
      this.partsService.createPart$(action.documentID, action.name).pipe(
    switchMap((part: Part) => of(new CreatePartSuccess(part))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  deletePart$ = this.actions$.pipe(
    ofType<DeletePart>(PartsActionTypes.DeletePart),
    switchMap((action: DeletePart) =>
      this.partsService.deletePart$(action.partID).pipe(
    switchMap((deletedPartID: number) => of(new DeletePartSuccess(deletedPartID))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  getUsesOfParts$ = this.actions$.pipe(
    ofType<GetUsesOfParts>(PartsActionTypes.GetUsesOfParts),
    map((action: GetUsesOfParts) => action.documentID),
    switchMap((partID) => this.partsService.getUsesOfParts$(partID).pipe(
    switchMap((usesOfParts: UsesOfParts) => of(new GetUsesOfPartsSuccess(usesOfParts))),
      catchError(err => of(new PartsServerError(err)))
    )));


  @Effect()
  linkPartToImage$ = this.actions$.pipe(
    ofType<LinkPartToImage>(PartsActionTypes.LinkPartToImage),
    switchMap((action: LinkPartToImage) =>
      this.partsService.linkPartToImage$(action.partUse).pipe(
    switchMap((partUse: PartUse) => of(new LinkPartToImageSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  unlinkPartToImage$ = this.actions$.pipe(
    ofType<UnlinkPartToImage>(PartsActionTypes.UnlinkPartToImage),
    switchMap((action: UnlinkPartToImage) =>
      this.partsService.unlinkPartToImage$(action.partUse).pipe(
    switchMap((partUse: PartUse) => of(new UnlinkPartToImageSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  linkPartToPage$ = this.actions$.pipe(
    ofType<LinkPartToPage>(PartsActionTypes.LinkPartToPage),
    switchMap((action: LinkPartToPage) =>
      this.partsService.linkPartToPage$(action.partUse).pipe(
    switchMap((partUse: PartUse) => of(new LinkPartToPageSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  unlinkPartToPage$ = this.actions$.pipe(
    ofType<UnlinkPartToPage>(PartsActionTypes.UnlinkPartToPage),
    switchMap((action: UnlinkPartToPage) =>
      this.partsService.unlinkPartToPage$(action.partUse).pipe(
    switchMap((partUse: PartUse) => of(new UnlinkPartToPageSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  linkPartToRegion$ = this.actions$.pipe(
    ofType<LinkPartToRegion>(PartsActionTypes.LinkPartToRegion),
    switchMap((action: LinkPartToRegion) =>
      this.partsService.linkPartToRegion$(action.partUse).pipe(
    switchMap((partUse: PartUse) => of(new LinkPartToRegionSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  @Effect()
  unlinkPartToRegion$ = this.actions$.pipe(
    ofType<UnlinkPartToRegion>(PartsActionTypes.UnlinkPartToRegion),
    switchMap((action: UnlinkPartToRegion) =>
      this.partsService.unlinkPartToRegion$(action.partUse).pipe(
    switchMap((partUse: PartUse) => of(new UnlinkPartToRegionSuccess(partUse))),
        catchError(err => of(new PartsServerError(err)))
      )));

  /*@Effect()
  getPartNamesUsedByImage$ = this.actions$.pipe(
    ofType<GetPartNamesUsedByImage>(PartsActionTypes.GetPartNamesUsedByImage),
    map((action: GetPartNamesUsedByImage) => action),
    switchMap((action) => this.partsService.getPartNamesUsedByImage$(action.imageID)),
    switchMap((parts: string[]) => {
      return of(new GetPartNamesUsedByImageSuccess(parts));
    })
  );*/
}
