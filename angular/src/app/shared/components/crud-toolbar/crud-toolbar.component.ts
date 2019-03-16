import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';


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
}
