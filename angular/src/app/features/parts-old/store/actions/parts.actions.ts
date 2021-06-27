import {Action} from '@ngrx/store';
import {Part} from '../../../../core/model/entities/part';
import {PartUse, UsesOfAllParts} from '../../../../core/model/restapi/uses-of-all-parts';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum PartsActionTypes {
  // revisado hasta aquí
  ResetPartsServerError = '[Parts] Reset ServerError',
  PartsLinkPartToImage = '[Parts] Link part to image',
  PartsLinkPartToImageSuccess = '[Parts] Link part to image success',
  PartsServerError = '[Parts] ServerError',
  PartsCreateImagePart = '[Parts] Create image part',
  PartsCreateImagePartSuccess = '[Parts] Create image part success',
  PartsCreatePagePart = '[Parts] Create page part',
  PartsCreatePagePartSuccess = '[Parts] Create page part success',
  PartsCreateRegionPart = '[Parts] Create region part',
  PartsCreateRegionPartSuccess = '[Parts] Create region part success',

  /*GetDocumentParts = '[Parts] Get document parts',
  GetDocumentPartsSuccess = '[Parts] Get document parts success',

  GetImageDocumentParts = '[Parts] Get image document parts',
  GetImageDocumentPartsSuccess = '[Parts] Get image document parts success',*/

  /*GetImagePart = '[Parts] Get image part',
  GetImagePartSuccess = '[Parts] Get image part success',
  GetPagePart = '[Parts] Get page part',
  GetPagePartSuccess = '[Parts] Get page part success',
  GetRegionPart = '[Parts] Get region part',
  GetRegionPartSuccess = '[Parts] Get region part success',
  GetSymbolPart = '[Parts] Get symbol part',
  GetSymbolPartSuccess = '[Parts] Get symbol part success',

  CreateSymbolPart = '[Parts] Create symbol part',
  CreateSymbolPartSuccess = '[Parts] Create symbol part success',

  UpdateImagePart = '[Parts] Update image part',
  UpdateImagePartSuccess = '[Parts] Update image part success',
  UpdatePagePart = '[Parts] Update page part',
  UpdatePagePartSuccess = '[Parts] Update page part success',
  UpdateRegionPart = '[Parts] Update region part',
  UpdateRegionPartSuccess = '[Parts] Update region part success',
  UpdateSymbolPart = '[Parts] Update symbol part',
  UpdateSymbolPartSuccess = '[Parts] Update symbol part success',*/

  PartsCreatePart = '[Parts] Create part',
  PartsCreatePartSuccess = '[Parts] Create part success',
  PartsRenamePart = '[Parts] Rename part',
  RenamePartSuccess = '[Parts] Rename part success',
  DeletePart = '[Parts] Delete part',
  DeletePartSuccess = '[Parts] Delete part success',

  GetUsesOfParts = '[Parts] Get uses of parts',
  GetUsesOfPartsSuccess = '[Parts] Get uses of parts success',

  UnlinkPartToImage = '[Parts] Unlink part to image',
  UnlinkPartToImageSuccess = '[Parts] Unlink part to image success',

  LinkPartToPage = '[Parts] Link part to page',
  LinkPartToPageSuccess = '[Parts] Link part to page success',

  UnlinkPartToPage = '[Parts] Unlink part to page',
  UnlinkPartToPageSuccess = '[Parts] Unlink part to page success',

  LinkPartToRegion = '[Parts] Link part to region',
  LinkPartToRegionSuccess = '[Parts] Link part to region success',

  UnlinkPartToRegion = '[Parts] Unlink part to region',
  UnlinkPartToRegionSuccess = '[Parts] Unlink part to region success',

  /*GetPartNamesUsedByImage = '[Parts] Get part names used by image',
  GetPartNamesUsedByImageSuccess = '[Parts] Get part names used by image success'*/
}


export class PartsLinkPartToImage implements Action {
  public readonly type = PartsActionTypes.PartsLinkPartToImage;
  constructor(public partUse: PartUse) {}
}

export class PartsLinkPartToImageSuccess implements Action {
  public readonly type = PartsActionTypes.PartsLinkPartToImageSuccess;
  constructor(public partUse: PartUse) {}
}



// revisado hasta aquí
export class ResetPartsServerError implements Action {
  public readonly type = PartsActionTypes.ResetPartsServerError;
  constructor() {}
}

export class PartsServerError implements Action {
  public readonly type = PartsActionTypes.PartsServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class CreateImagePart implements Action {
  public readonly type = PartsActionTypes.PartsCreateImagePart;
  constructor(public imageId: number, public partName: string) {}
}

export class CreateImagePartSuccess implements Action {
  public readonly type = PartsActionTypes.PartsCreateImagePartSuccess;
  constructor(public partUse: PartUse) {}
}

export class CreatePagePart implements Action {
  public readonly type = PartsActionTypes.PartsCreatePagePart;
  constructor(public pageId: number, public partName: string) {}
}

export class CreatePagePartSuccess implements Action {
  public readonly type = PartsActionTypes.PartsCreatePagePartSuccess;
  constructor(public partUse: PartUse) {}
}

export class CreateRegionPart implements Action {
  public readonly type = PartsActionTypes.PartsCreateRegionPart;
  constructor(public regionId: number, public partName: string) {}
}

export class CreateRegionPartSuccess implements Action {
  public readonly type = PartsActionTypes.PartsCreateRegionPartSuccess;
  constructor(public partUse: PartUse) {}
}


/*export class GetDocumentParts implements Action {
  public readonly type = PartsActionTypes.GetDocumentParts;
  constructor(public documentID: number) {}
}

export class GetDocumentPartsSuccess implements Action {
  public readonly type = PartsActionTypes.GetDocumentPartsSuccess;
  constructor(public parts: Part[]) {}
}

export class GetImageDocumentParts implements Action {
  public readonly type = PartsActionTypes.GetImageDocumentParts;
  constructor(public imageID: number) {}
}

export class GetImageDocumentPartsSuccess implements Action {
  public readonly type = PartsActionTypes.GetImageDocumentPartsSuccess;
  constructor(public parts: Part[]) {}
}*/
/*
export class GetImagePart implements Action {
  public readonly type = PartsActionTypes.GetImagePart;
  constructor(public image: Image) {}
}

export class GetImagePartSuccess implements Action {
  public readonly type = PartsActionTypes.GetImagePartSuccess;
  constructor(public part: Part) {}
}

export class UpdateImagePart implements Action {
  public readonly type = PartsActionTypes.UpdateImagePart;
  constructor(public image: Image, public part: Part) {}
}

export class UpdateImagePartSuccess implements Action {
  public readonly type = PartsActionTypes.UpdateImagePartSuccess;
  constructor(public part: Part) {}
}

export class GetPagePart implements Action {
  public readonly type = PartsActionTypes.GetPagePart;
  constructor(public page: Page) {}
}

export class GetPagePartSuccess implements Action {
  public readonly type = PartsActionTypes.GetPagePartSuccess;
  constructor(public part: Part) {}
}

export class UpdatePagePart implements Action {
  public readonly type = PartsActionTypes.UpdatePagePart;
  constructor(public page: Page, public part: Part) {}
}

export class UpdatePagePartSuccess implements Action {
  public readonly type = PartsActionTypes.UpdatePagePartSuccess;
  constructor(public part: Part) {}
}

export class GetRegionPart implements Action {
  public readonly type = PartsActionTypes.GetRegionPart;
  constructor(public region: Region) {}
}

export class GetRegionPartSuccess implements Action {
  public readonly type = PartsActionTypes.GetRegionPartSuccess;
  constructor(public part: Part) {}
}

export class UpdateRegionPart implements Action {
  public readonly type = PartsActionTypes.UpdateRegionPart;
  constructor(public region: Region, public part: Part) {}
}

export class UpdateRegionPartSuccess implements Action {
  public readonly type = PartsActionTypes.UpdateRegionPartSuccess;
  constructor(public part: Part) {}
}

export class GetSymbolPart implements Action {
  public readonly type = PartsActionTypes.GetSymbolPart;
  constructor(public symbol: AgnosticSymbol) {}
}

export class GetSymbolPartSuccess implements Action {
  public readonly type = PartsActionTypes.GetSymbolPartSuccess;
  constructor(public part: Part) {}
}

export class UpdateSymbolPart implements Action {
  public readonly type = PartsActionTypes.UpdateSymbolPart;
  constructor(public symbol: AgnosticSymbol, public part: Part) {}
}

export class UpdateSymbolPartSuccess implements Action {
  public readonly type = PartsActionTypes.UpdateSymbolPartSuccess;
  constructor(public part: Part) {}
}

export class CreateSymbolPart implements Action {
  public readonly type = PartsActionTypes.CreateSymbolPart;
  constructor(public symbol: AgnosticSymbol, public partName: string) {}
}

export class CreateSymbolPartSuccess implements Action {
  public readonly type = PartsActionTypes.CreateSymbolPartSuccess;
  constructor(public part: Part) {}
}
*/
export class RenamePart implements Action {
  public readonly type = PartsActionTypes.PartsRenamePart;
  constructor(public part: Part, public newName: string) {}
}

export class RenamePartSuccess implements Action {
  public readonly type = PartsActionTypes.RenamePartSuccess;
  constructor(public part: Part) {}
}

export class DeletePart implements Action {
  public readonly type = PartsActionTypes.DeletePart;
  constructor(public partID: number) {}
}

export class DeletePartSuccess implements Action {
  public readonly type = PartsActionTypes.DeletePartSuccess;
  constructor(public deletedPartID: number) {}
}

export class CreatePart implements Action {
  public readonly type = PartsActionTypes.PartsCreatePart;
  constructor(public documentID: number, public name: string) {}
}

export class CreatePartSuccess implements Action {
  public readonly type = PartsActionTypes.PartsCreatePartSuccess;
  constructor(public part: Part) {}
}

export class GetUsesOfParts implements Action {
  public readonly type = PartsActionTypes.GetUsesOfParts;
  constructor(public documentID: number) {}
}

export class GetUsesOfPartsSuccess implements Action {
  public readonly type = PartsActionTypes.GetUsesOfPartsSuccess;
  constructor(public usesOfParts: UsesOfAllParts) {}
}

export class UnlinkPartToImage implements Action {
  public readonly type = PartsActionTypes.UnlinkPartToImage;
  constructor(public partUse: PartUse) {}
}

export class UnlinkPartToImageSuccess implements Action {
  public readonly type = PartsActionTypes.UnlinkPartToImageSuccess;
  constructor(public partUse: PartUse) {}
}

export class LinkPartToPage implements Action {
  public readonly type = PartsActionTypes.LinkPartToPage;
  constructor(public partUse: PartUse) {}
}

export class LinkPartToPageSuccess implements Action {
  public readonly type = PartsActionTypes.LinkPartToPageSuccess;
  constructor(public partUse: PartUse) {}
}

export class UnlinkPartToPage implements Action {
  public readonly type = PartsActionTypes.UnlinkPartToPage;
  constructor(public partUse: PartUse) {}
}

export class UnlinkPartToPageSuccess implements Action {
  public readonly type = PartsActionTypes.UnlinkPartToPageSuccess;
  constructor(public partUse: PartUse) {}
}

export class LinkPartToRegion implements Action {
  public readonly type = PartsActionTypes.LinkPartToRegion;
  constructor(public partUse: PartUse) {}
}

export class LinkPartToRegionSuccess implements Action {
  public readonly type = PartsActionTypes.LinkPartToRegionSuccess;
  constructor(public partUse: PartUse) {}
}

export class UnlinkPartToRegion implements Action {
  public readonly type = PartsActionTypes.UnlinkPartToRegion;
  constructor(public partUse: PartUse) {}
}

export class UnlinkPartToRegionSuccess implements Action {
  public readonly type = PartsActionTypes.UnlinkPartToRegionSuccess;
  constructor(public partUse: PartUse) {}
}

/*export class GetPartNamesUsedByImage implements Action {
  public readonly type = PartsActionTypes.GetPartNamesUsedByImage;
  constructor(public imageID: number) {}
}

export class GetPartNamesUsedByImageSuccess implements Action {
  public readonly type = PartsActionTypes.GetPartNamesUsedByImageSuccess;
  constructor(public parts: string[]) {}
}*/

export type PartsActions =
  // revisado hasta aquí
  PartsLinkPartToImage | PartsLinkPartToImageSuccess |

  ResetPartsServerError | PartsServerError |
  CreateImagePart | CreateImagePartSuccess |
  CreatePagePart | CreatePagePartSuccess |
  CreateRegionPart | CreateRegionPartSuccess |
  /*GetDocumentParts | GetDocumentPartsSuccess |
  GetImageDocumentParts | GetImageDocumentPartsSuccess |*/
 /* GetImagePart | GetImagePartSuccess | UpdateImagePart | UpdateImagePartSuccess |
  GetPagePart | GetPagePartSuccess | UpdatePagePart | UpdatePagePartSuccess |
  GetRegionPart | GetRegionPartSuccess | UpdateRegionPart | UpdateRegionPartSuccess |
  GetSymbolPart | GetSymbolPartSuccess | UpdateSymbolPart | UpdateSymbolPartSuccess |
  PartsCreateImagePart | PartsCreateImagePartSuccess |
  PartsCreatePagePart | PartsCreatePagePartSuccess |
  PartsCreateRegionPart | PartsCreateRegionPartSuccess |
  CreateSymbolPart | CreateSymbolPartSuccess |*/
  CreatePart | CreatePartSuccess |
  RenamePart | RenamePartSuccess |
  DeletePart | DeletePartSuccess |
  GetUsesOfParts | GetUsesOfPartsSuccess |

  UnlinkPartToImage | UnlinkPartToImageSuccess |
  LinkPartToPage | LinkPartToPageSuccess |
  UnlinkPartToPage | UnlinkPartToPageSuccess |
  LinkPartToRegion | LinkPartToRegionSuccess |
  UnlinkPartToRegion | UnlinkPartToRegionSuccess;
  // | GetPartNamesUsedByImage | GetPartNamesUsedByImageSuccess;
