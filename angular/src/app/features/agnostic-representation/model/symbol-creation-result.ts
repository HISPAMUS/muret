import {AgnosticSymbol} from '../../../core/model/entities/agnosticSymbol';
import {AgnosticSymbolAndPosition} from './agnostic-symbol-and-position';

export interface SymbolCreationResult {
  agnosticSymbol: AgnosticSymbol;
  classifiedSymbols: AgnosticSymbolAndPosition[];
}
