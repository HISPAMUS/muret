import {AgnosticSymbol} from '../../../core/model/entities/agnostic-symbol';
import {AgnosticOrSemanticSymbolAndPosition} from './agnostic-or-semantic-symbol-and-position';

export interface SymbolCreationResult {
  pageID: number;
  regionID: number;
  agnosticSymbol: AgnosticSymbol;
  classifiedSymbols: AgnosticOrSemanticSymbolAndPosition[];
}
