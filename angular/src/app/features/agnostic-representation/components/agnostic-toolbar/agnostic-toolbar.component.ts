import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {AgnosticSymbolToolbarCategory} from '../../model/agnostic-symbol-toolbar-category';
import {Store} from '@ngrx/store';
import {AgnosticRepresentationState} from '../../store/state/agnostic-representation.state';
import {SVGSet} from '../../model/svgset';
import {AgnosticTypeSVGPath} from '../../model/agnostic-type-svgpath';

@Component({
  selector: 'app-agnostic-toolbar',
  templateUrl: './agnostic-toolbar.component.html',
  styleUrls: ['./agnostic-toolbar.component.css']
})
export class AgnosticToolbarComponent implements OnInit, OnDestroy {
  // @Input() agnosticSymbolToolbarCategories: AgnosticSymbolToolbarCategory[];
  @Input() svgAgnosticSymbolSet: SVGSet;
  @Input() mode: 'eIdle' | 'eAdding' | 'eSelecting' | 'eEditing';
  @Output() agnosticSymbolTypeSelected = new EventEmitter<string>();
  @Output() pitchUp = new EventEmitter();
  @Output() pitchDown = new EventEmitter();
  @Output() classifierChanged = new EventEmitter<boolean>();

  private selectedAgnosticSymbolTypeValue: string;

  collapsed: Map<string, boolean>;
  classifierValue = true;

  constructor(public store: Store<AgnosticRepresentationState>) {
  }

  ngOnInit() {
    this.collapsed = new Map();
    /*this.agnosticSymbolToolbarCategories.forEach(category => {
      this.collapsed.set(category.name, false);
    });*/
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
      this.agnosticSymbolTypeSelected.emit(this.selectedAgnosticSymbolTypeValue);
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

  isCollapsed(category: AgnosticSymbolToolbarCategory): boolean {
    return this.collapsed.get(category.name);
  }

  toggleCollapsed(category: AgnosticSymbolToolbarCategory) {
    const prev = this.collapsed.get(category.name);
    this.collapsed.set(category.name, !prev);
  }

  inAddingMode() {
    return this.mode === 'eAdding';
  }

  movePitchDownSelectedSymbol() {
    this.pitchDown.emit();
  }

  movePitchUpSelectedSymbol() {
    this.pitchUp.emit();
  }

  trackSVGSymbolFn(index, item: AgnosticTypeSVGPath) {
    return index;
  }

}
