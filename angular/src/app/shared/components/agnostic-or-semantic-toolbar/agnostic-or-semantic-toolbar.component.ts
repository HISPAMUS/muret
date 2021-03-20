import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Store} from '@ngrx/store';
import {SVGSet} from "../../../features/agnostic-representation/model/svgset";
import {AgnosticOrSemanticSymbolAndPosition} from "../../../features/agnostic-representation/model/agnostic-or-semantic-symbol-and-position";
import {AgnosticOrSemanticTypeSVGPath} from "../../../features/agnostic-representation/model/agnostic-or-semantic-type-s-v-g-path";
import {AgnosticRepresentationState} from "../../../features/agnostic-representation/store/state/agnostic-representation.state";
import {KeyValue} from "@angular/common";

@Component({
  selector: 'app-agnostic-or-semantic-toolbar',
  templateUrl: './agnostic-or-semantic-toolbar.component.html',
  styleUrls: ['./agnostic-or-semantic-toolbar.component.css']
})
export class AgnosticOrSemanticToolbarComponent implements OnInit, OnDestroy {
  @Input() filters: Array<KeyValue<string, string>>; // map<values, titles>
  @Input() filter: AgnosticOrSemanticSymbolAndPosition[];

  @Input() svgAgnosticOrSemanticSymbolSet: SVGSet;
  @Input() mode: 'eIdle' | 'eAdding' | 'eSelecting' | 'eEditing'; // @deprecated
  @Input() frequentSymbols: Map<string, number>; // key = agnostic key value, value = frequency

  @Output() agnosticOrSemanticSymbolSelected = new EventEmitter<AgnosticOrSemanticTypeSVGPath>();
  @Output() pitchUp = new EventEmitter();
  @Output() pitchDown = new EventEmitter();
  @Output() classifierChanged = new EventEmitter<boolean>();

  private selectedAgnosticOrSemanticSymbolTypeValue: string;

  classifierValue = true;
  symbolsFilter = 'frequent'; // default value
  buttonWidth: number;

  constructor(public store: Store<AgnosticRepresentationState>) {
  }

  ngOnInit() {
  }

  ngOnDestroy(): void {
  }

  @Input()
  get selectedAgnosticOrSemanticSymbolType() {
    return this.selectedAgnosticOrSemanticSymbolTypeValue;
  }

  set selectedAgnosticOrSemanticSymbolType(val) {
    if (this.selectedAgnosticOrSemanticSymbolTypeValue !== val) {
      this.selectedAgnosticOrSemanticSymbolTypeValue = val;
    }
  }

  @Input()
  get classifier() {
    return this.classifierValue;
  }

  set classifier(val) {
    if (this.classifierValue !== val) {
      this.classifierValue = val;
      this.classifierChanged.emit(val);
    }
  }

  /*inAddingMode() {
    return this.mode === 'eAdding';
  }

  movePitchDown() {
    this.pitchDown.emit();
  }

  movePitchUp() {
    this.pitchUp.emit();
  }*/

  trackSVGSymbolFn(index, item: AgnosticOrSemanticTypeSVGPath) {
    return index;
  }
  //TODO Esto debe ser genérico o venir como parámetro !!!!!
  getFilteredSymbols() {
    this.buttonWidth = 70;
    if (this.filter) { // from input
      const filterAgnosticTypes = this.filter.map(agnosticTypePosition => agnosticTypePosition.agnosticOrSemanticSymbolType);
      const result = this.svgAgnosticOrSemanticSymbolSet.paths.filter(
        value => filterAgnosticTypes.includes(value.agnosticOrSemanticTypeString)
      );
      return result;
    } else {
      switch (this.symbolsFilter) {
        case 'rest.':
          this.buttonWidth = 100;
          return this.svgAgnosticOrSemanticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes(this.symbolsFilter));
        case 'note.':
          this.buttonWidth = 55;
          return this.svgAgnosticOrSemanticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes(this.symbolsFilter)
            && !value.agnosticOrSemanticTypeString.includes('beam'));
        case 'other':
          return this.svgAgnosticOrSemanticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes('defect') ||
            value.agnosticOrSemanticTypeString.includes('fermata') || value.agnosticOrSemanticTypeString.includes('digit') ||
            value.agnosticOrSemanticTypeString.includes('slur') || !value.agnosticOrSemanticTypeString.includes('.') ||
            value.agnosticOrSemanticTypeString.includes('breath'));
        case 'clefsmeters':
          return this.svgAgnosticOrSemanticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes('clef') ||
            value.agnosticOrSemanticTypeString.includes('metersign'));
        case 'frequent':
          if (this.frequentSymbols) {
            return this.svgAgnosticOrSemanticSymbolSet.paths.filter(value => this.frequentSymbols.has(value.agnosticOrSemanticTypeString)).sort((a, b) => this.frequentSymbols.get(b.agnosticOrSemanticTypeString) - this.frequentSymbols.get(a.agnosticOrSemanticTypeString));
          } else {
            return null;
          }
          // sort decreasing orderEntities
        default:
          return this.svgAgnosticOrSemanticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes(this.symbolsFilter));
      }
    }
  }

  showFilter() {
    return undefined === this.filter || this.filter === null;
  }

  onRadioButtonClick(svgSymbol: AgnosticOrSemanticTypeSVGPath) {
    this.agnosticOrSemanticSymbolSelected.emit(svgSymbol);
  }
}
