import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';
import {SVGSet} from '../../model/svgset';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {BoundingBox} from '../../../../core/model/entities/bounding-box';
import {Point} from '../../../../core/model/entities/point';
import {SymbolCreationResult} from '../../model/symbol-creation-result';
import {ClassifierModel} from '../../../../core/model/entities/classifier-model';

export enum AgnosticRepresentationActionTypes {
  InitRegion = '[AgnosticRepresentation] Init region',
  GetRegion = '[AgnosticRepresentation] Get region',
  GetRegionSuccess = '[AgnosticRepresentation] Get region success',
  SelectSymbol = '[AgnosticRepresentation] Select symbol',
  DeselectSymbol = '[AgnosticRepresentation] Deselect symbol',
  GetSVGSet = '[AgnosticRepresentation] Get SVG set',
  GetSVGSetSucccess = '[AgnosticRepresentation] Get SVG set success',
  ChangeSymbol = '[AgnosticRepresentation] Change symbol',
  ChangeSymbolBoundingBox = '[AgnosticRepresentation] Change symbol bounding box',
  ChangeSymbolComments = '[AgnosticRepresentation] Change symbol comments',
  ChangeSymbolSuccess = '[AgnosticRepresentation] Change symbol success',
  /*ClassifySymbolFromBoundingBox = '[AgnosticRepresentation] Classify symbol from bounding box',
  ClassifySymbolFromStrokes = '[AgnosticRepresentation] Classify symbol from strokes',
  ClassifySymbolSuccess = '[AgnosticRepresentation] Classify symbol success',*/
  CreateSymbolFromBoundingBox = '[AgnosticRepresentation] Create symbol from bounding box',
  CreateSymbolFromStrokes = '[AgnosticRepresentation] Create symbol from strokes',
  CreateSymbolSuccess = '[AgnosticRepresentation] Create symbol success',
  DeleteSymbol = '[AgnosticRepresentation] Delete symbol',
  DeleteSymbolSuccess = '[AgnosticRepresentation] Delete symbol success',
  ClassifyRegionEndToEnd = '[AgnosticRepresentation] Classify region end-to-end',
  ClassifyRegionEndToEndSuccess = '[AgnosticRepresentation] Classify region end-to-end success',
  ClearRegionSymbols = '[AgnosticRepresentation] Clear region symbols',
  ClearRegionSymbolsSuccess = '[AgnosticRepresentation] Clear region symbols success',
  GetSymbolClassifierModels = '[AgnosticRepresentation] Get Symbol Classifier Models',
  GetSymbolClassifierModelsSuccess = '[AgnosticRepresentation] Get Symbol Classifier Models success',
  GetAgnosticEnd2EndClassifierModels = '[AgnosticRepresentation] Get Agnostic end2end Classifier Models',
  GetAgnosticEnd2EndClassifierModelsSuccess = '[AgnosticRepresentation] Get Agnostic end2end Classifier Models success',

}

export class InitRegion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.InitRegion;
  constructor() {}
}

export class GetRegion implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegion;
  constructor(public id: number) {}
}

export class GetRegionSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetRegionSuccess;
  constructor(public region: Region) {}
}

export class SelectSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.SelectSymbol;
  constructor(public agnosticSymbolID: number) {}
}

export class DeselectSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.DeselectSymbol;
  constructor() {}
}

export class GetSVGSet implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSet;
  constructor(public notationType: string, public manuscriptType: string) {}
}

export class GetSVGSetSucccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSVGSetSucccess;
  constructor(public svgSet: SVGSet) {}
}

export class ChangeSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbol;
  constructor(public agnosticSymbol: AgnosticSymbol, public agnosticSymbolType: string, public positionInStaff: string) {}
}

export class ChangeSymbolSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolSuccess;
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}

export class ChangeSymbolBoundingBox implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolBoundingBox;
  constructor(public agnosticSymbol: AgnosticSymbol, public boundingBox: BoundingBox) {}
}

export class ChangeSymbolComments implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ChangeSymbolComments;
  constructor(public agnosticSymbol: AgnosticSymbol, public comments: string) {}
}

/*export class ClassifySymbolFromBoundingBox implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClassifySymbolFromBoundingBox;
  constructor(public regionID: number, public boundingBox: BoundingBox) {}
}

export class ClassifySymbolFromStrokes implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClassifySymbolFromStrokes;
  constructor(public regionID: number, public points: Point[][]) {}
}

export class ClassifySymbolSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClassifySymbolSuccess
  constructor(public classifiedSymbols: AgnosticSymbolAndPosition[]) {}
}*/

export class CreateSymbolFromBoundingBox implements Action {
  public readonly type = AgnosticRepresentationActionTypes.CreateSymbolFromBoundingBox;
  constructor(public modelID: string, public regionID: number, public boundingBox: BoundingBox,
              public agnosticSymbolType: string, public positionInStaff: string) {
  }
}

export class CreateSymbolFromStrokes implements Action {
  public readonly type = AgnosticRepresentationActionTypes.CreateSymbolFromStrokes;
  constructor(public modelID: string, public regionID: number, public points: Point[][],
              public agnosticSymbolType: string, public positionInStaff: string) {}
}

export class CreateSymbolSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.CreateSymbolSuccess;
  constructor(public symbolCreationResult: SymbolCreationResult) {}
}

export class DeleteSymbol implements Action {
  public readonly type = AgnosticRepresentationActionTypes.DeleteSymbol;
  constructor(public agnosticSymbolID: number) {}
}

export class DeleteSymbolSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.DeleteSymbolSuccess;
  constructor(public deletedAgnosticSymbolID: number) {}
}

export class ClassifyRegionEndToEnd implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClassifyRegionEndToEnd;
  constructor(public modelID: string, public regionID: number) {}
}

export class ClassifyRegionEndToEndSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClassifyRegionEndToEndSuccess;
  constructor(public classifiedSymbols: AgnosticSymbol[]) {}
}

export class ClearRegionSymbols implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClearRegionSymbols;
  constructor(public regionID: number) {}
}

export class ClearRegionSymbolsSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.ClearRegionSymbolsSuccess;
  constructor(public deleted: boolean) {}
}


export class GetSymbolClassifierModels implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSymbolClassifierModels;
  // constructor(public collectionID: number, public projectID: number, public notationType: string, public manuscriptType: string) {}
  constructor(public imageID: number) {}
}

export class GetSymbolClassifierModelsSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetSymbolClassifierModelsSuccess;
  constructor(public classifierModels: ClassifierModel[]) {}
}

export class GetAgnosticEnd2EndClassifierModels implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetAgnosticEnd2EndClassifierModels;
  // constructor(public collectionID: number, public projectID: number, public notationType: string, public manuscriptType: string) {}
  constructor(public imageID: number) {}
}

export class GetAgnosticEnd2EndClassifierModelsSuccess implements Action {
  public readonly type = AgnosticRepresentationActionTypes.GetAgnosticEnd2EndClassifierModelsSuccess;
  constructor(public classifierModels: ClassifierModel[]) {
  }
}



export type AgnosticRepresentationActions =
  InitRegion | GetRegion | GetRegionSuccess | GetSVGSet | GetSVGSetSucccess | SelectSymbol | DeselectSymbol |
  ChangeSymbol | ChangeSymbolComments | ChangeSymbolBoundingBox | ChangeSymbolSuccess |
  // ClassifySymbolFromBoundingBox | ClassifySymbolFromStrokes | ClassifySymbolSuccess |
  CreateSymbolFromBoundingBox | CreateSymbolFromStrokes | CreateSymbolSuccess | DeleteSymbol | DeleteSymbolSuccess |
  ClassifyRegionEndToEnd | ClassifyRegionEndToEndSuccess |
  ClearRegionSymbols | ClearRegionSymbolsSuccess |
  GetSymbolClassifierModels | GetSymbolClassifierModelsSuccess |
  GetAgnosticEnd2EndClassifierModels | GetAgnosticEnd2EndClassifierModelsSuccess;
