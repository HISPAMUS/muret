import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Store} from '@ngrx/store';
import {Subscription} from 'rxjs';
import {SVGSet} from "../../../features/agnostic-representation/model/svgset";
import {AgnosticSymbolAndPosition} from "../../../features/agnostic-representation/model/agnostic-symbol-and-position";
import {AgnosticOrSemanticTypeSVGPath} from "../../../features/agnostic-representation/model/agnostic-or-semantic-type-s-v-g-path";
import {AgnosticRepresentationState} from "../../../features/agnostic-representation/store/state/agnostic-representation.state";
import {State} from "../../../core/model/entities/state";

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit, OnDestroy {
  @Input() filters: Map<string, string>; // map<values, titles>

  @Input() svgAgnosticSymbolSet: SVGSet;
  @Input() mode: 'eIdle' | 'eAdding' | 'eSelecting' | 'eEditing';
  @Input() filter: AgnosticSymbolAndPosition[];
  @Input() frequentSymbols: Map<string, number>; // key = agnostic key value, value = frequency

  @Output() agnosticSymbolSelected = new EventEmitter<AgnosticOrSemanticTypeSVGPath>();
  @Output() pitchUp = new EventEmitter();
  @Output() pitchDown = new EventEmitter();
  @Output() classifierChanged = new EventEmitter<boolean>();

  private selectedAgnosticSymbolTypeValue: string;

  classifierValue = true;
  symbolsFilter = 'frequent'; // default value
  buttonWidth: number;

  private serverErrorSubscription: Subscription;

  constructor(public store: Store<AgnosticRepresentationState>) {
  }

  ngOnInit() {
  }

  ngOnDestroy(): void {
  }

  @Input()
  get selectedAgnosticSymbolType() {
    return this.selectedAgnosticSymbolTypeValue;
  }

  set selectedAgnosticSymbolType(val) {
    if (this.selectedAgnosticSymbolTypeValue !== val) {
      this.selectedAgnosticSymbolTypeValue = val;
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

  movePitchDownSelectedSymbol() {
    this.pitchDown.emit();
  }

  movePitchUpSelectedSymbol() {
    this.pitchUp.emit();
  }*/

  trackSVGSymbolFn(index, item: AgnosticOrSemanticTypeSVGPath) {
    return index;
  }

  getFilteredSymbols() {
    this.buttonWidth = 70;
    if (this.filter) { // from input
      const filterAgnosticTypes = this.filter.map(agnosticTypePosition => agnosticTypePosition.agnosticSymbolType);
      const result = this.svgAgnosticSymbolSet.paths.filter(
        value => filterAgnosticTypes.includes(value.agnosticOrSemanticTypeString)
      );
      return result;
    } else {
      switch (this.symbolsFilter) {
        case 'rest.':
          this.buttonWidth = 100;
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes(this.symbolsFilter));
        case 'note.':
          this.buttonWidth = 55;
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes(this.symbolsFilter)
            && !value.agnosticOrSemanticTypeString.includes('beam'));
        case 'other':
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes('defect') ||
            value.agnosticOrSemanticTypeString.includes('fermata') || value.agnosticOrSemanticTypeString.includes('digit') ||
            value.agnosticOrSemanticTypeString.includes('slur') || !value.agnosticOrSemanticTypeString.includes('.') ||
            value.agnosticOrSemanticTypeString.includes('breath'));
        case 'clefsmeters':
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes('clef') ||
            value.agnosticOrSemanticTypeString.includes('metersign'));
        case 'frequent':
          return this.svgAgnosticSymbolSet.paths.filter(value => this.frequentSymbols.has(value.agnosticOrSemanticTypeString)).
            sort((a, b) => this.frequentSymbols.get(b.agnosticOrSemanticTypeString) - this.frequentSymbols.get(a.agnosticOrSemanticTypeString));
          // sort decreasing order
        default:
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticOrSemanticTypeString.includes(this.symbolsFilter));
      }
    }
  }

  showFilter() {
    return undefined === this.filter || this.filter === null;
  }

  onRadioButtonClick(svgSymbol: AgnosticOrSemanticTypeSVGPath) {
    this.agnosticSymbolSelected.emit(svgSymbol);
  }
}
