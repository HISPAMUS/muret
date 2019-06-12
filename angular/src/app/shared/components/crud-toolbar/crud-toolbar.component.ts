import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {DeselectSymbol} from '../../../features/agnostic-representation/store/actions/agnostic-representation.actions';


@Component({
  selector: 'app-crud-toolbar',
  templateUrl: './crud-toolbar.component.html',
  styleUrls: ['./crud-toolbar.component.css']
})
export class CrudToolbarComponent implements OnInit {
  @Output() onDelete = new EventEmitter();
  @Output() onClear = new EventEmitter();
  private modeValue: 'eIdle' | 'eEditing' | 'eAdding' | 'eSelecting';
  @Output() modeChange = new EventEmitter();

  @Output() onZoomIn = new EventEmitter();
  @Output() onZoomOut = new EventEmitter();
  @Output() onZoomFit = new EventEmitter();
  @Output() onAddComment = new EventEmitter();

  constructor() {
    // ------- menus --------
  }

  ngOnInit() {
    this.mode = 'eIdle';
  }

  @Input()
  get mode() {
    return this.modeValue;
  }

  set mode(val) {
    if (this.modeValue !== val) {
      this.modeValue = val;
      this.modeChange.emit(this.modeValue);
    }
  }

  deleteSelected() {
    this.onDelete.emit();
  }

  clear() {
    this.onClear.emit();
  }

  isEditingMode(): boolean {
    return this.mode === 'eEditing';
  }

  zoomOut() {
    this.onZoomOut.emit();
  }

  zoomIn() {
    this.onZoomIn.emit();
  }

  zoomFit() {
    this.onZoomFit.emit();
  }

  displayMode(): string {
    switch (this.mode) {
      case 'eAdding':
        return 'Adding';
      case 'eEditing':
        return 'Editing';
      case 'eIdle':
        return 'Viewing';
    }
  }

  isAddingMode() {
    return this.mode === 'eAdding';
  }

  @HostListener('window:keyup', ['$event'])
  keyEvent(event: KeyboardEvent) {
    switch (event.code) {
      case 'Delete':
        if (this.mode === 'eEditing' || this.mode === 'eAdding') {
          this.onDelete.emit();
        }
        break;
      case 'Escape':
        this.mode = 'eIdle';
        break;
      case 'KeyA':
        if (event.altKey) {
          this.mode = 'eAdding';
        }
        break;
      case 'KeyE':
        if (event.altKey) {
          this.mode = 'eEditing';
        }
        break;
    }
  }

  addCommentToSelected() {
    this.onAddComment.emit();
  }
}
