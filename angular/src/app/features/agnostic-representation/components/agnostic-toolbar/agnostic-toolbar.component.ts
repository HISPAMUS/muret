import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {AgnosticSymbolToolbarCategory} from '../../model/agnostic-symbol-toolbar-category';
import {Store} from '@ngrx/store';
import {AgnosticRepresentationState} from '../../store/state/agnostic-representation.state';
import {Subscription} from 'rxjs';
import {AgnosticSymbol} from '../../../../core/model/entities/agnosticSymbol';
import {selectSelectedSymbol} from '../../store/selectors/agnostic-representation.selector';
import {ChangeSymbolPositionInStaff, ChangeSymbolType} from '../../store/actions/agnostic-representation.actions';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-agnostic-toolbar',
  templateUrl: './agnostic-toolbar.component.html',
  styleUrls: ['./agnostic-toolbar.component.css']
})
export class AgnosticToolbarComponent implements OnInit, OnDestroy {
  @Input() agnosticSymbolToolbarCategories: AgnosticSymbolToolbarCategory[];
  @Input() notationType: string;
  @Input() manuscriptType: string;
  @Output() onAgnosticSymbolTypeSelected = new EventEmitter<string>();
  @Output() onPitchUp = new EventEmitter();
  @Output() onPitchDown = new EventEmitter();

  private selectedAgnosticSymbolTypeValue: string;

  collapsed: Map<string, boolean>;


  constructor(public store: Store<AgnosticRepresentationState>) {
  }

  ngOnInit() {
    this.collapsed = new Map();
    this.agnosticSymbolToolbarCategories.forEach(category => {
      this.collapsed.set(category.name, false);
    });
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
      this.onAgnosticSymbolTypeSelected.emit(this.selectedAgnosticSymbolTypeValue);
    }
  }


  isCollapsed(category: AgnosticSymbolToolbarCategory): boolean {
    return this.collapsed.get(category.name);
  }

  toggleCollapsed(category: AgnosticSymbolToolbarCategory) {
    const prev = this.collapsed.get(category.name);
    this.collapsed.set(category.name, !prev);
  }

  movePitchDownSelectedSymbol() {
    this.onPitchDown.emit();
  }

  movePitchUpSelectedSymbol() {
    this.onPitchUp.emit();
  }
}
