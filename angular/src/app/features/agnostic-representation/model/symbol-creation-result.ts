import {AgnosticSymbol} from '../../../core/model/entities/agnosticSymbol';
import {AgnosticOrSemanticSymbolAndPosition} from './agnostic-or-semantic-symbol-and-position';

export interface SymbolCreationResult {
  agnosticSymbol: AgnosticSymbol;
  classifiedSymbols: AgnosticOrSemanticSymbolAndPosition[];
}
