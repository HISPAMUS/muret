import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';
import {Part} from '../../../../core/model/entities/part';
import {Image} from '../../../../core/model/entities/image';
import {Page} from '../../../../core/model/entities/page';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {UsesOfParts} from '../../../../core/model/restapi/uses-of-parts';
import {GetProjectStatisticsSuccess, ProjectActionTypes} from '../../../project/store/actions/project.actions';

export enum PartsActionTypes {
  /*GetProjectParts = '[Parts] Get project parts',
  GetProjectPartsSuccess = '[Parts] Get project parts success',

  GetImageProjectParts = '[Parts] Get image project parts',
  GetImageProjectPartsSuccess = '[Parts] Get image project parts success',*/

  GetImagePart = '[Parts] Get image part',
  GetImagePartSuccess = '[Parts] Get image part success',
  GetPagePart = '[Parts] Get page part',
  GetPagePartSuccess = '[Parts] Get page part success',
  GetRegionPart = '[Parts] Get region part',
  GetRegionPartSuccess = '[Parts] Get region part success',
  GetSymbolPart = '[Parts] Get symbol part',
  GetSymbolPartSuccess = '[Parts] Get symbol part success',

  CreateImagePart = '[Parts] Create image part',
  CreateImagePartSuccess = '[Parts] Create image part success',
  CreatePagePart = '[Parts] Create page part',
  CreatePagePartSuccess = '[Parts] Create page part success',
  CreateRegionPart = '[Parts] Create region part',
  CreateRegionPartSuccess = '[Parts] Create region part success',
  CreateSymbolPart = '[Parts] Create symbol part',
  CreateSymbolPartSuccess = '[Parts] Create symbol part success',

  UpdateImagePart = '[Parts] Update image part',
  UpdateImagePartSuccess = '[Parts] Update image part success',
  UpdatePagePart = '[Parts] Update page part',
  UpdatePagePartSuccess = '[Parts] Update page part success',
  UpdateRegionPart = '[Parts] Update region part',
  UpdateRegionPartSuccess = '[Parts] Update region part success',
  UpdateSymbolPart = '[Parts] Update symbol part',
  UpdateSymbolPartSuccess = '[Parts] Update symbol part success',

  CreatePart = '[Parts] Create part',
  CreatePartSuccess = '[Parts] Create part success',
  RenamePart = '[Parts] Rename part',
  RenamePartSuccess = '[Parts] Rename part success',
  DeletePart = '[Parts] Delete part',
  DeletePartSuccess = '[Parts] Delete part success',

  GetUsesOfParts = '[Parts] Get uses of parts',
  GetUsesOfPartsSuccess = '[Parts] Get uses of parts success',

  /*GetPartNamesUsedByImage = '[Parts] Get part names used by image',
  GetPartNamesUsedByImageSuccess = '[Parts] Get part names used by image success'*/
}

/*export class GetProjectParts implements Action {
  public readonly type = PartsActionTypes.GetProjectParts;
  constructor(public projectID: number) {}
}

export class GetProjectPartsSuccess implements Action {
  public readonly type = PartsActionTypes.GetProjectPartsSuccess;
  constructor(public parts: Part[]) {}
}

export class GetImageProjectParts implements Action {
  public readonly type = PartsActionTypes.GetImageProjectParts;
  constructor(public imageID: number) {}
}

export class GetImageProjectPartsSuccess implements Action {
  public readonly type = PartsActionTypes.GetImageProjectPartsSuccess;
  constructor(public parts: Part[]) {}
}*/

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

export class CreateImagePart implements Action {
  public readonly type = PartsActionTypes.CreateImagePart;
  constructor(public image: Image, public partName: string) {}
}

export class CreateImagePartSuccess implements Action {
  public readonly type = PartsActionTypes.CreateImagePartSuccess;
  constructor(public part: Part) {}
}

export class CreatePagePart implements Action {
  public readonly type = PartsActionTypes.CreatePagePart;
  constructor(public page: Page, public partName: string) {}
}

export class CreatePagePartSuccess implements Action {
  public readonly type = PartsActionTypes.CreatePagePartSuccess;
  constructor(public part: Part) {}
}

export class CreateRegionPart implements Action {
  public readonly type = PartsActionTypes.CreateRegionPart;
  constructor(public region: Region, public partName: string) {}
}

export class CreateRegionPartSuccess implements Action {
  public readonly type = PartsActionTypes.CreateRegionPartSuccess;
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

export class RenamePart implements Action {
  public readonly type = PartsActionTypes.RenamePart;
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
  public readonly type = PartsActionTypes.CreatePart;
  constructor(public projectID: number, public name: string) {}
}

export class CreatePartSuccess implements Action {
  public readonly type = PartsActionTypes.CreatePartSuccess;
  constructor(public part: Part) {}
}
export class GetUsesOfParts implements Action {
  public readonly type = PartsActionTypes.GetUsesOfParts;
  constructor(public partID: number) {}
}

export class GetUsesOfPartsSuccess implements Action {
  public readonly type = PartsActionTypes.GetUsesOfPartsSuccess;
  constructor(public usesOfParts: UsesOfParts) {}
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
  /*GetProjectParts | GetProjectPartsSuccess |
  GetImageProjectParts | GetImageProjectPartsSuccess |*/
  GetImagePart | GetImagePartSuccess | UpdateImagePart | UpdateImagePartSuccess |
  GetPagePart | GetPagePartSuccess | UpdatePagePart | UpdatePagePartSuccess |
  GetRegionPart | GetRegionPartSuccess | UpdateRegionPart | UpdateRegionPartSuccess |
  GetSymbolPart | GetSymbolPartSuccess | UpdateSymbolPart | UpdateSymbolPartSuccess |
  CreateImagePart | CreateImagePartSuccess |
  CreatePagePart | CreatePagePartSuccess |
  CreateRegionPart | CreateRegionPartSuccess |
  CreateSymbolPart | CreateSymbolPartSuccess |
  CreatePart | CreatePartSuccess |
  RenamePart | RenamePartSuccess |
  DeletePart | DeletePartSuccess |
  GetUsesOfParts | GetUsesOfPartsSuccess;
  // | GetPartNamesUsedByImage | GetPartNamesUsedByImageSuccess;

