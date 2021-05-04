import { Action } from '@ngrx/store';
import {ImageOverview} from "../../../../core/model/restapi/image-overview";
import {Page} from "../../../../core/model/entities/page";
import {PartLinking} from "../../../../core/model/restapi/part-linking";
import {PagesRegionsSymbolsAndNewPart} from "../../../../core/model/restapi/pages-regions-symbols-and-new-part";
import {Part} from "../../../../core/model/entities/part";
import {ImageRecognitionProgressStatusChange} from "../../../../core/model/restapi/image-recognition-progress-status-change";
import {ImageRecognitionProgressStatus} from "../../../../core/model/entities/image-recognition-progress-status";
import {Region} from "../../../../core/model/entities/region";
import {RegionType} from "../../../../core/model/entities/region-type";
import {ChangedRegionTypes} from "../../../../core/model/restapi/changed-region-types";
import {BoundingBox} from "../../../../core/model/entities/bounding-box";
import {NumberArray} from "../../../../core/model/restapi/number-array";
import {ClassifierModel} from "../../../../core/model/entities/classifier-model";
import {DocumentAnalysisForm} from "../../../../core/model/restapi/document-analysis-form";
import {Point} from "../../../../core/model/entities/point";
import {AgnosticSymbol} from "../../../../core/model/entities/agnostic-symbol";
import {Notation} from "../../../../shared/services/notation";
import {SymbolCreationResult} from "../../../agnostic-representation-old/model/symbol-creation-result";
import {StringResponse} from "../../../../core/model/restapi/string-response";
import {RotatedImage} from "../../../../core/model/restapi/rotated-image";

/**
 * We use the same actions for overview, parts, document analysis ... because they share the state
 */
export enum ImageRecognitionActionTypes {
  //ImageRecognitionServerError = '[ImageRecognition] Server error',

  ImageRecognitionGetImageOverview = '[ImageRecognition] Get image overview',
  ImageRecognitionGetImageOverviewSuccess = '[ImageRecognition] Get image overview success',
  ImageRecognitionGetPagesRegionsSymbols = '[ImageRecognition] Get pages, regions, symbols',
  ImageRecognitionGetPagesRegionsSymbolsSuccess = '[ImageRecognition] Get pages, regions, symbols success',
  ImageRecognitionPutComments = '[ImageRecognition] Put comments',
  ImageRecognitionPutCommentsSuccess = '[ImageRecognition] Put comments success',
  ImageRecognitionChangeStatus = '[ImageRecognition] Change status',
  ImageRecognitionChangeStatusSuccess = '[ImageRecognition] Change status success',

  ImageRecognitionLinkPart = '[ImageRecognition - Parts] Link part',
  ImageRecognitionLinkPartSuccess = '[ImageRecognition - Parts] Link part success',
  ImageRecognitionLinkNewPart = '[ImageRecognition - Parts] Link new part',
  ImageRecognitionLinkNewPartSuccess = '[ImageRecognition - Parts] Link new part success',
  ImageRecognitionUnlinkPart = '[ImageRecognition - Parts] Unlink part',
  ImageRecognitionUnlinkPartSuccess = '[ImageRecognition - Parts] Unlink part success',

  ImageRecognitionLinkImageToPart = '[ImageRecognition - Parts] Link part to image',
  ImageRecognitionLinkImageToPartSuccess = '[ImageRecognition - Parts] Link part to image success',
  ImageRecognitionLinkImageToNewPart = '[ImageRecognition - Parts] Link new part to image',
  ImageRecognitionLinkImageToNewPartSuccess = '[ImageRecognition - Parts] Link new part to image success',
  ImageRecognitionUnlinkImageFromPart = '[ImageRecognition - Parts] Unlink part from image',
  ImageRecognitionUnlinkImageFromPartSuccess = '[ImageRecognition - Parts] Unlink part from image success',

  ImageRecognitionGetRegionTypes = '[Image recognition. Document Analysis] Get region types',
  ImageRecognitionGetRegionTypesSuccess = '[Image recognition. Document Analysis] Get region types success',
  ImageRecognitionChangeRegionsType = '[Image Recognition. Document Analysis] Change regions type',
  ImageRecognitionChangeRegionsTypeSuccess = '[Image Recognition. Document Analysis] Change regions type success',
  ImageRecognitionChangeRegionBoundingBox = '[Image Recognition. Document Analysis] Change region bounding box',
  ImageRecognitionChangeRegionBoundingBoxSuccess = '[Image Recognition. Document Analysis] Change region bounding box success',
  ImageRecognitionChangePageBoundingBox = '[Image Recognition. Document Analysis] Change page bounding box',
  ImageRecognitionChangePageBoundingBoxSuccess = '[Image Recognition. Document Analysis] Change page bounding box success',
  ImageRecognitionCreatePage = '[Image Recognition. Document Analysis] Create page',
  ImageRecognitionCreatePageSuccess = '[Image Recognition. Document Analysis] Create page success',
  ImageRecognitionCreatePages = '[Image Recognition. Document Analysis] Create pages',
  ImageRecognitionCreatePagesSuccess = '[Image Recognition. Document Analysis] Create pages success',
  ImageRecognitionCreateRegion = '[Image Recognition. Document Analysis] Create region',
  ImageRecognitionCreateRegionSuccess = '[Image Recognition. Document Analysis] Create region success',
  ImageRecognitionClear = '[Image Recognition. Document Analysis] Clear',
  ImageRecognitionClearSuccess = '[Image Recognition. Document Analysis] Clear success',
  ImageRecognitionDeletePages = '[Image Recognition. Document Analysis] Delete pages',
  ImageRecognitionDeletePagesSuccess = '[Image Recognition. Document Analysis] Delete pages success',
  ImageRecognitionDeleteRegions = '[Image Recognition. Document Analysis] Delete region',
  ImageRecognitionDeleteRegionsSuccess = '[Image Recognition. Document Analysis] Delete region success',
  ImageRecognitionAutomaticDocumentAnalysis = '[Image Recognition. Document Analysis] Start automatic analysis',
  ImageRecognitionAutomaticDocumentAnalysisSuccess = '[Image Recognition. Document Analysis] Automatic analysis success',
  ImageRecognitionAutoRotate = '[Image Recognition. Document Analysis] Auto rotate',
  ImageRecognitionAutoRotateSuccess = '[Image Recognition. Document Analysis] Auto rotate success',
  ImageRecognitionApplyRotation = '[Image Recognition. Document Analysis] Apply rotation',
  ImageRecognitionApplyRotationSuccess = '[Image Recognition. Document Analysis] Apply rotation success',
  ImageRecognitionRevertRotation = '[Image Recognition. Document Analysis] Revert rotation',
  ImageRecognitionRevertRotationSuccess = '[Image Recognition. Document Analysis] Apply revert rotation success',
  ImageRecognitionGetClassifierModels = '[Image Recognition] Get Models',
  ImageRecognitionGetClassifierModelsSuccess = '[Image Recognition] Get Models Success',

  ImageRecognitionSelectRegion = '[Image Recognition] Select region',
  ImageRecognitionSelectAgnosticSymbols = '[Image Recognition. Agnostic representation] Select agnostic symbols',
  ImageRecognitionCreateSymbolFromBoundingBox = '[Image Recognition. AgnosticRepresentation] Create symbol from bounding box',
  ImageRecognitionCreateSymbolFromStrokes = '[Image Recognition. AgnosticRepresentation] Create symbol from strokes',
  ImageRecognitionCreateSymbolSuccess = '[Image Recognition. AgnosticRepresentation] Create symbol success',
  ImageRecognitionDeleteSymbols = '[Image Recognition. AgnosticRepresentation] Delete symbol',
  ImageRecognitionDeleteSymbolsSuccess = '[Image Recognition. AgnosticRepresentation] Delete symbol success',
  ImageRecognitionClassifyRegionEndToEnd = '[Image Recognition. AgnosticRepresentation] Classify region end-to-end',
  ImageRecognitionClassifyRegionEndToEndSuccess = '[Image Recognition. AgnosticRepresentation] Classify region end-to-end success',
  ImageRecognitionClearRegionSymbols = '[Image Recognition. AgnosticRepresentation] Clear region symbols',
  ImageRecognitionClearRegionSymbolsSuccess = '[Image Recognition. AgnosticRepresentation] Clear region symbols success',
  ImageRecognitionChangeSymbolsType = '[Image Recognition. AgnosticRepresentation] Change symbol type',
  ImageRecognitionChangeSymbolsPosition = '[Image Recognition. AgnosticRepresentation] Change symbol position',
  ImageRecognitionMoveSymbolsPosition = '[Image Recognition. AgnosticRepresentation] Move symbol position',
  ImageRecognitionChangeSymbolBoundingBox = '[Image Recognition. AgnosticRepresentation] Change symbol bounding box',
  ImageRecognitionChangeSymbolComments = '[Image Recognition. AgnosticRepresentation] Change symbol comments',
  ImageRecognitionChangeSymbolsSuccess = '[Image Recognition. AgnosticRepresentation] Change symbols success',
  ImageRecognitionChangeRegionExternalReference = '[Image Recognition. AgnosticRepresentation] Change region external reference comments',
  ImageRecognitionChangeRegionExternalReferenceSuccess = '[Image Recognition. AgnosticRepresentation] Change region external reference success',
  ImageRecognitionChangeSymbolX = '[Image Recognition. AgnosticRepresentation] Change symbol X',
  ImageRecognitionChangeSymbolXSuccess = '[Image Recognition. AgnosticRepresentation] Change symbol X success',

  ImageRecognitionConvertAgnostic2Semantic = '[Image Recognition. SemanticRepresentation] Convert agnostic to semantic',
  ImageRecognitionConvertAgnostic2SemanticSuccess = '[Image Recognition. SemanticRepresentation] Convert agnostic to semantic success',
  ImageRecognitionGetNotation = '[Image Recognition. SemanticRepresentation] Get notation',
  ImageRecognitionGetNotationSuccess = '[Image Recognition. SemanticRepresentation] Get notation success',
  ImageRecognitionSendSemanticEncoding = '[Image Recognition. SemanticRepresentation] Send semantic encoding',
  ImageRecognitionSendSemanticEncodingSuccess = '[Image Recognition. SemanticRepresentation] Send semantic encoding success',
  ImageRecognitionChangeNotationType = '[Image Recognition. SemanticRepresentation] Change notation type',
  ImageRecognitionChangeNotationTypeSuccess = '[Image Recognition. SemanticRepresentation] Change notation type success',
  ImageRecognitionSelectNotationSymbol = '[Image Recognition] Select notation symbol',
  ImageRecognitionLinkSymbolsAgnosticSemantic = '[Image Recognition. SemanticRepresentation] Link symbols agnostic semantic ',
  ImageRecognitionLinkSymbolsAgnosticSemanticSuccess = '[Image Recognition. SemanticRepresentation] Link symbols agnostic semantic success'

}

export class ImageRecognitionGetImageOverview implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetImageOverview;
  constructor(public imageID: number) {}
}

export class ImageRecognitionGetImageOverviewSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetImageOverviewSuccess;
  constructor(public imageOverview: ImageOverview) {}
}


/*export class ImageRecognitionServerError implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionServerError;
  constructor(public serverError: APIRestServerError) {}
}*/

export class ImageRecognitionGetPagesRegionsSymbolsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbolsSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export class ImageRecognitionGetPagesRegionsSymbols implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetPagesRegionsSymbols;
  constructor(public imageID: number) {}
}

export class ImageRecognitionPutComments implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionPutComments;
  constructor(public imageID: number, public comments: string) {}
}

export class ImageRecognitionPutCommentsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionPutCommentsSuccess;
  constructor(public comments: StringResponse) {}
}


export class ImageRecognitionChangeStatus implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeStatus;
  constructor(public imageRecognitionProgressStatusChange: ImageRecognitionProgressStatusChange) {}
}

export class ImageRecognitionChangeStatusSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeStatusSuccess;
  constructor(public statuses: ImageRecognitionProgressStatus[]) {}
}


// ------ Parts ----


export class ImageRecognitionLinkPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionLinkPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkPartSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}

export class ImageRecognitionLinkNewPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkNewPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionLinkNewPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkNewPartSuccess;
  constructor(public pagesRegionsSymbolsAndNewPart: PagesRegionsSymbolsAndNewPart) {}
}


export class ImageRecognitionUnlinkPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkPart;
  constructor(public payload: PartLinking) {}
}

export class ImageRecognitionUnlinkPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkPartSuccess;
  constructor(public pagesRegionsSymbols: Page[]) {}
}


export class ImageRecognitionLinkImageToPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToPart;
  constructor(public imageID: number, public partID: number) {}
}

export class ImageRecognitionLinkImageToPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToPartSuccess;
  constructor(public part: Part) {}
}

export class ImageRecognitionLinkImageToNewPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPart;
  constructor(public imageID: number, public partName: string) {}
}

export class ImageRecognitionLinkImageToNewPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkImageToNewPartSuccess;
  constructor(public part: Part) {}
}

export class ImageRecognitionUnlinkImageFromPart implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPart;
  constructor(public imageID: number) {}
}

export class ImageRecognitionUnlinkImageFromPartSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionUnlinkImageFromPartSuccess;
  constructor() {}
}

// ----- Document analysis

export class ImageRecognitionGetRegionTypes implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetRegionTypes;
  constructor() {
  }
}

export class ImageRecognitionGetRegionTypesSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetRegionTypesSuccess;
  constructor(public regionTypes: RegionType[]) {}
}

export class ImageRecognitionChangeRegionsType implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionsType;
  constructor(public regions: Region[], public regionType: RegionType) {}
}

export class ImageRecognitionChangeRegionsTypeSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionsTypeSuccess;
  constructor(public changeRegionTypes: ChangedRegionTypes) {}
}

export class ImageRecognitionChangeRegionBoundingBox implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionBoundingBox;
  constructor(public region: Region, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionChangeRegionBoundingBoxSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionBoundingBoxSuccess;
  constructor(public region: Region) {}
}

export class ImageRecognitionChangePageBoundingBox implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangePageBoundingBox;
  constructor(public page: Page, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionChangePageBoundingBoxSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangePageBoundingBoxSuccess;
  constructor(public page: Page) {}
}

export class ImageRecognitionCreatePage implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePage;
  constructor(public imageID: number, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionCreatePageSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePageSuccess;
  constructor(public pages: Page[]) {} // it returns several pagesWithRegions because some regions may have changed its page
}

export class ImageRecognitionCreatePages implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePages;
  constructor(public imageID: number, public numPages: number) {}
}

export class ImageRecognitionCreatePagesSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreatePagesSuccess;
  constructor(public pages: Page[]) {} // new pagesWithRegions
}

export class ImageRecognitionCreateRegion implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateRegion;
  constructor(public imageID: number, public regionType: RegionType, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionCreateRegionSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateRegionSuccess;
  constructor(public pages: Page[]) {} // it returns several pagesWithRegions because we don't a priori in which page the region has been created
}

export class ImageRecognitionDeletePages implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeletePages;
  constructor(public pages: Page[]) {}
}

export class ImageRecognitionDeletePagesSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeletePagesSuccess;
  constructor(public deletedPageIDs: NumberArray) {}
}

export class ImageRecognitionDeleteRegions implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeleteRegions;
  constructor(public regions: Region[]) {}
}

export class ImageRecognitionDeleteRegionsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeleteRegionsSuccess;
  constructor(public deletedRegionIDs: NumberArray) {}
}

export class ImageRecognitionClear implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClear;
  constructor(public imageID: number) {}
}

export class ImageRecognitionClearSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClearSuccess;
  constructor() {}
}

export class ImageRecognitionGetClassifierModels implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetClassifierModels;
  constructor(public imageID: number) {}
}

export class ImageRecognitionGetClassifierModelsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetClassifierModelsSuccess;
  constructor(public response: ClassifierModel[]) {}
}

export class ImageRecognitionAutomaticDocumentAnalysis implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionAutomaticDocumentAnalysis;
  constructor(public form: DocumentAnalysisForm) {}
}

export class ImageRecognitionAutomaticDocumentAnalysisSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionAutomaticDocumentAnalysisSuccess;
  constructor(public pages: Page[]) {}
}

export class ImageRecognitionApplyRotation implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionApplyRotation;
  constructor(public imageID: number, public rotationDegrees: number) {}
}

export class ImageRecognitionApplyRotationSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionApplyRotationSuccess;
  constructor(public rotatedImage: RotatedImage) {
  }
}

export class ImageRecognitionAutoRotate implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionAutoRotate;
  constructor(public imageID: number) {}
}

export class ImageRecognitionAutoRotateSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionAutoRotateSuccess;
  constructor(public rotatedImage: RotatedImage) {}
}


export class ImageRecognitionRevertRotation implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionRevertRotation;
  constructor(public imageID: number) {}
}

export class ImageRecognitionRevertRotationSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionRevertRotationSuccess;
  constructor() {}
}



// ------- Agnostic representation
export class ImageRecognitionSelectRegion implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionSelectRegion;
  constructor(public region: Region) {
  }
}

export class ImageRecognitionSelectAgnosticSymbols implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionSelectAgnosticSymbols;
  constructor(public agnosticSymbols: AgnosticSymbol[]) {
  }
}
export class ImageRecognitionCreateSymbolFromBoundingBox implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateSymbolFromBoundingBox;
  constructor(public modelID: string, public regionID: number, public boundingBox: BoundingBox,
              public agnosticSymbolType: string, public positionInStaff: string) {
  }
}

export class ImageRecognitionCreateSymbolFromStrokes implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateSymbolFromStrokes;
  constructor(public modelID: string, public regionID: number, public points: Point[][],
              public agnosticSymbolType: string, public positionInStaff: string) {}
}

export class ImageRecognitionCreateSymbolSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionCreateSymbolSuccess;
  constructor(public symbolCreationResult: SymbolCreationResult) {}
}

export class ImageRecognitionDeleteSymbols implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeleteSymbols;
  constructor(public agnosticSymbols: AgnosticSymbol[]) {}
}

export class ImageRecognitionDeleteSymbolsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionDeleteSymbolsSuccess;
  constructor(public deletedAgnosticSymbolIDs: NumberArray) {}
}

export class ImageRecognitionClassifyRegionEndToEnd implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClassifyRegionEndToEnd;
  constructor(public modelID: string, public regionID: number) {}
}

export class ImageRecognitionClassifyRegionEndToEndSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClassifyRegionEndToEndSuccess;
  constructor(public classifiedSymbols: AgnosticSymbol[]) {}
}

export class ImageRecognitionClearRegionSymbols implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClearRegionSymbols;
  constructor(public regionID: number) {}
}

export class ImageRecognitionClearRegionSymbolsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionClearRegionSymbolsSuccess;
  constructor(public deleted: boolean) {}
}

/*export class ImageRecognitionChangeSymbol implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbol;
  constructor(public agnosticSymbol: AgnosticSymbol, public agnosticSymbolType: string, public positionInStaff: string) {}
}*/

export class ImageRecognitionChangeSymbolsType implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolsType;
  constructor(public agnosticSymbols: AgnosticSymbol[], public agnosticSymbolType: string) {}
}

export class ImageRecognitionChangeSymbolsPosition implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolsPosition;
  constructor(public agnosticSymbols: AgnosticSymbol[], public positionInStaff: string) {}
}

export class ImageRecognitionMoveSymbolsPosition implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionMoveSymbolsPosition;
  constructor(public agnosticSymbols: AgnosticSymbol[], public difference: number) {}
}

export class ImageRecognitionChangeSymbolsSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolsSuccess;
  constructor(public agnosticSymbols: AgnosticSymbol[]) {}
}

export class ImageRecognitionChangeSymbolBoundingBox implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolBoundingBox;
  constructor(public agnosticSymbol: AgnosticSymbol, public boundingBox: BoundingBox) {}
}

export class ImageRecognitionChangeSymbolComments implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolComments;
  constructor(public agnosticSymbol: AgnosticSymbol, public comments: string) {}
}


export class ImageRecognitionChangeRegionExternalReference implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionExternalReference;
  constructor(public region: Region, public externalReference: string) {}
}


export class ImageRecognitionChangeRegionExternalReferenceSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeRegionExternalReferenceSuccess;
  constructor(public region: Region) {}
}

export class ImageRecognitionChangeSymbolX implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolX;
  constructor(public symbol: AgnosticSymbol, public newX: number) {}
}

export class ImageRecognitionChangeSymbolXSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeSymbolXSuccess;
  constructor(public agnosticSymbol: AgnosticSymbol) {}
}


// ---- semantic
export class ImageRecognitionConvertAgnostic2Semantic implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionConvertAgnostic2Semantic;
  constructor(public classifierModelID: string, public region: Region, public mensustriche: boolean, public renderer: 'verovio' | 'im3') {}
}

export class ImageRecognitionConvertAgnostic2SemanticSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionConvertAgnostic2SemanticSuccess;
  constructor(public notation: Notation) {}
}

export class ImageRecognitionGetNotation implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetNotation;
  constructor(public region: Region, public mensustriche: boolean, public renderer: 'verovio' | 'im3') {}
}

export class ImageRecognitionGetNotationSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionGetNotationSuccess;
  constructor(public notation: Notation) {}
}

export class ImageRecognitionSendSemanticEncoding implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionSendSemanticEncoding;
  constructor(public region: Region, public semanticEncoding: string, public mensustriche: boolean, public renderer: 'verovio' | 'im3') {}
}

export class ImageRecognitionSendSemanticEncodingSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionSendSemanticEncodingSuccess;
  constructor(public notation: Notation) {}
}

export class ImageRecognitionChangeNotationType implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeNotationType;
  constructor(public region: Region, public notationType: string) {}
}

export class ImageRecognitionChangeNotationTypeSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionChangeNotationTypeSuccess;
  constructor(public region: Region) {}
}

export class ImageRecognitionSelectNotationSymbol implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionSelectNotationSymbol;
  constructor(public notationSymbolID: string) {
  }
}


export class ImageRecognitionLinkSymbolsAgnosticSemantic implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkSymbolsAgnosticSemantic;
  constructor(public selectedRegion: Region, public semanticEncoding: string) {
  }
}

export class ImageRecognitionLinkSymbolsAgnosticSemanticSuccess implements Action {
  public readonly type = ImageRecognitionActionTypes.ImageRecognitionLinkSymbolsAgnosticSemanticSuccess;
  constructor(public semanticEncoding: String) {
  }
}

export type ImageRecognitionActions =
  //ImageRecognitionServerError |
  ImageRecognitionGetImageOverview | ImageRecognitionGetImageOverviewSuccess |
  ImageRecognitionGetPagesRegionsSymbols | ImageRecognitionGetPagesRegionsSymbolsSuccess |
  ImageRecognitionPutComments | ImageRecognitionPutCommentsSuccess |
  ImageRecognitionChangeStatus | ImageRecognitionChangeStatusSuccess |

  // parts
  ImageRecognitionLinkPart | ImageRecognitionLinkPartSuccess |
  ImageRecognitionLinkNewPart | ImageRecognitionLinkNewPartSuccess |
  ImageRecognitionUnlinkPart | ImageRecognitionUnlinkPartSuccess |
  ImageRecognitionLinkImageToPart | ImageRecognitionLinkImageToPartSuccess |
  ImageRecognitionLinkImageToNewPart | ImageRecognitionLinkImageToNewPartSuccess |
  ImageRecognitionUnlinkImageFromPart | ImageRecognitionUnlinkImageFromPartSuccess |

  // document analysis
  ImageRecognitionGetRegionTypes | ImageRecognitionGetRegionTypesSuccess |
  ImageRecognitionChangeRegionsType | ImageRecognitionChangeRegionsTypeSuccess |
  ImageRecognitionChangeRegionBoundingBox | ImageRecognitionChangeRegionBoundingBoxSuccess |
  ImageRecognitionChangePageBoundingBox | ImageRecognitionChangePageBoundingBoxSuccess |
  ImageRecognitionCreatePage | ImageRecognitionCreatePageSuccess |
  ImageRecognitionCreatePages | ImageRecognitionCreatePagesSuccess |
  ImageRecognitionCreateRegion | ImageRecognitionCreateRegionSuccess |
  ImageRecognitionClear | ImageRecognitionClearSuccess |
  ImageRecognitionDeletePages | ImageRecognitionDeletePagesSuccess |
  ImageRecognitionDeleteRegions | ImageRecognitionDeleteRegionsSuccess |

  ImageRecognitionGetClassifierModels | ImageRecognitionGetClassifierModelsSuccess |
  ImageRecognitionAutomaticDocumentAnalysis | ImageRecognitionAutomaticDocumentAnalysisSuccess |

  ImageRecognitionApplyRotation | ImageRecognitionApplyRotationSuccess |
  ImageRecognitionRevertRotation | ImageRecognitionRevertRotationSuccess |
  ImageRecognitionAutoRotate | ImageRecognitionAutoRotateSuccess |

  // agnostic representation
  ImageRecognitionSelectRegion | ImageRecognitionSelectAgnosticSymbols |
  ImageRecognitionCreateSymbolFromBoundingBox | ImageRecognitionCreateSymbolFromStrokes | ImageRecognitionCreateSymbolSuccess |
  ImageRecognitionDeleteSymbols | ImageRecognitionDeleteSymbolsSuccess |
  ImageRecognitionClassifyRegionEndToEnd | ImageRecognitionClassifyRegionEndToEndSuccess |
  ImageRecognitionClearRegionSymbols | ImageRecognitionClearRegionSymbolsSuccess |
  ImageRecognitionChangeSymbolsType | ImageRecognitionChangeSymbolsPosition | ImageRecognitionMoveSymbolsPosition | ImageRecognitionChangeSymbolComments | ImageRecognitionChangeSymbolBoundingBox | ImageRecognitionChangeSymbolsSuccess |
  ImageRecognitionChangeRegionExternalReference | ImageRecognitionChangeRegionExternalReferenceSuccess |
  ImageRecognitionChangeSymbolX | ImageRecognitionChangeSymbolXSuccess |

  // semantic representation
  ImageRecognitionConvertAgnostic2Semantic | ImageRecognitionConvertAgnostic2SemanticSuccess | ImageRecognitionGetNotation | ImageRecognitionGetNotationSuccess |
  ImageRecognitionSendSemanticEncoding | ImageRecognitionSendSemanticEncodingSuccess |
  ImageRecognitionChangeNotationType | ImageRecognitionChangeNotationTypeSuccess |
  ImageRecognitionSelectNotationSymbol |
  ImageRecognitionLinkSymbolsAgnosticSemantic | ImageRecognitionLinkSymbolsAgnosticSemanticSuccess

  ;

