import {Action} from '@ngrx/store';
import {Region} from '../../../../core/model/entities/region';
import {Notation} from '../../services/notation';
import { ClassifierModel } from 'src/app/core/model/entities/classifier-model';
import {APIRestServerError} from '../../../../core/model/restapi/apirest-server-error';

export enum SemanticRepresentationActionTypes {
  ResetSemanticRepresentationServerError = '[SemanticRepresentation] Reset Server error',
  SemanticRepresentationServerError = '[SemanticRepresentation] Server error',
  ConvertAgnostic2Semantic = '[SemanticRepresentation] Convert agnostic to semantic',
  ConvertAgnostic2SemanticSuccess = '[SemanticRepresentation] Convert agnostic to semantic success',
  GetNotation = '[SemanticRepresentation] Get notation',
  GetNotationSuccess = '[SemanticRepresentation] Get notation success',
  ClearNotation = '[SemanticRepresentation] Clear notation',
  SendSemanticEncoding = '[SemanticRepresentation] Send semantic encoding',
  SendSemanticEncodingSuccess = '[SemanticRepresentation] Send semantic encoding success',
  GetTranslationModels = '[SemanticRepresentation] Get translation models',
  GetTranslationModelsSuccess = '[SemanticRepresentation] Get translation models success',
  SelectSymbol = '[SemanticRepresentation] Select symbol',
  DeselectSymbol = '[SemanticRepresentation] Deselect symbol',
}

export class ResetSemanticRepresentationServerError implements Action {
  public readonly type = SemanticRepresentationActionTypes.ResetSemanticRepresentationServerError;
  constructor() {}
}

export class SemanticRepresentationServerError implements Action {
  public readonly type = SemanticRepresentationActionTypes.SemanticRepresentationServerError;
  constructor(public serverError: APIRestServerError) {}
}

export class ConvertAgnostic2Semantic implements Action {
  public readonly type = SemanticRepresentationActionTypes.ConvertAgnostic2Semantic;
  constructor(public region: Region, public mensustriche: boolean, public renderer: 'verovio' | 'im3') {}
}

export class ConvertAgnostic2SemanticSuccess implements Action {
  public readonly type = SemanticRepresentationActionTypes.ConvertAgnostic2SemanticSuccess;
  constructor(public notation: Notation) {}
}

export class GetNotation implements Action {
  public readonly type = SemanticRepresentationActionTypes.GetNotation;
  constructor(public region: Region, public mensustriche: boolean, public renderer: 'verovio' | 'im3') {}
}

export class GetNotationSuccess implements Action {
  public readonly type = SemanticRepresentationActionTypes.GetNotationSuccess;
  constructor(public notation: Notation) {}
}

export class ClearNotation implements Action {
  public readonly type = SemanticRepresentationActionTypes.ClearNotation;
  constructor() {}
}

export class SendSemanticEncoding implements Action {
  public readonly type = SemanticRepresentationActionTypes.SendSemanticEncoding;
  constructor(public region: Region, public semanticEncoding: string, public mensustriche: boolean, public renderer: 'verovio' | 'im3') {}
}

export class SendSemanticEncodingSuccess implements Action {
  public readonly type = SemanticRepresentationActionTypes.SendSemanticEncodingSuccess;
  constructor(public notation: Notation) {}
}

export class GetTranslationModels implements Action {
  public readonly type = SemanticRepresentationActionTypes.GetTranslationModels;
  constructor(public imageID: number) {}
}

export class GetTranslationModelsSuccess implements Action {
  public readonly type = SemanticRepresentationActionTypes.GetTranslationModelsSuccess;
  constructor(public response: ClassifierModel[]) {}
}

export class SelectSymbol implements Action {
  public readonly type = SemanticRepresentationActionTypes.SelectSymbol;
  constructor(public semanticSymbolID: number) {}
}

export class DeselectSymbol implements Action {
  public readonly type = SemanticRepresentationActionTypes.DeselectSymbol;
  constructor() {}
}

export type SemanticRepresentationActions =
  ResetSemanticRepresentationServerError | SemanticRepresentationServerError |
  ConvertAgnostic2Semantic | ConvertAgnostic2SemanticSuccess | GetNotation | GetNotationSuccess | ClearNotation |
  SendSemanticEncoding | SendSemanticEncodingSuccess | GetTranslationModels | GetTranslationModelsSuccess |
  SelectSymbol | DeselectSymbol;
