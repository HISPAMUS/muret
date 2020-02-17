import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Store} from '@ngrx/store';
import {AgnosticRepresentationState} from '../../store/state/agnostic-representation.state';
import {SVGSet} from '../../model/svgset';
import {AgnosticTypeSVGPath} from '../../model/agnostic-type-svgpath';
import {AgnosticSymbolAndPosition} from '../../model/agnostic-symbol-and-position';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-agnostic-toolbar',
  templateUrl: './agnostic-toolbar.component.html',
  styleUrls: ['./agnostic-toolbar.component.css']
})
export class AgnosticToolbarComponent implements OnInit, OnDestroy {
  @Input() svgAgnosticSymbolSet: SVGSet;
  @Input() mode: 'eIdle' | 'eAdding' | 'eSelecting' | 'eEditing';
  @Input() filter: AgnosticSymbolAndPosition[];
  @Input() frequentSymbols: Map<string, number>; // key = agnostic key value, value = frequency

  @Output() agnosticSymbolSelected = new EventEmitter<AgnosticTypeSVGPath>();
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

  trackSVGSymbolFn(index, item: AgnosticTypeSVGPath) {
    return index;
  }

  getFilteredSymbols() {
    this.buttonWidth = 70;
    if (this.filter) { // from input
      const filterAgnosticTypes = this.filter.map(agnosticTypePosition => agnosticTypePosition.agnosticSymbolType);
      const result = this.svgAgnosticSymbolSet.paths.filter(
        value => filterAgnosticTypes.includes(value.agnosticTypeString)
      );
      return result;
    } else {
      switch (this.symbolsFilter) {
        case 'rest.':
          this.buttonWidth = 100;
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticTypeString.includes(this.symbolsFilter));
        case 'note.':
          this.buttonWidth = 55;
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticTypeString.includes(this.symbolsFilter)
            && !value.agnosticTypeString.includes('beam'));
        case 'other':
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticTypeString.includes('defect') ||
            value.agnosticTypeString.includes('fermata') || value.agnosticTypeString.includes('digit') ||
            value.agnosticTypeString.includes('slur') || !value.agnosticTypeString.includes('.'));
        case 'clefsmeters':
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticTypeString.includes('clef') ||
            value.agnosticTypeString.includes('metersign'));
        case 'frequent':
          return this.svgAgnosticSymbolSet.paths.filter(value => this.frequentSymbols.has(value.agnosticTypeString)).
            sort((a, b) => this.frequentSymbols.get(b.agnosticTypeString) - this.frequentSymbols.get(a.agnosticTypeString));
          // sort decreasing order
        default:
          return this.svgAgnosticSymbolSet.paths.filter(value => value.agnosticTypeString.includes(this.symbolsFilter));
      }
    }
  }

  showFilter() {
    return undefined === this.filter || this.filter === null;
  }

  onRadioButtonClick(svgSymbol: AgnosticTypeSVGPath) {
    this.agnosticSymbolSelected.emit(svgSymbol);
  }
}
