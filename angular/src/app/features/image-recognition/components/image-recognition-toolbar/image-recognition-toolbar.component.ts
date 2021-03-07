import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {ZoomManager} from "../../../../shared/model/zoom-manager";

@Component({
  selector: 'app-image-recognition-toolbar',
  templateUrl: './image-recognition-toolbar.component.html',
  styleUrls: ['./image-recognition-toolbar.component.css']
})
export class ImageRecognitionToolbarComponent implements OnInit {
  @Input() selectionDone: boolean;
  @Output() onDelete = new EventEmitter();
  @Output() onClear = new EventEmitter();
  private modeValue: 'eEditing' | 'eAdding' | 'eSelecting';
  @Output() modeChange = new EventEmitter();

  @Output() onAddComment = new EventEmitter();
  @Output() onDeleteAll = new EventEmitter();

  @Input() hideModeButtons: boolean;
  @Input() zoomManager: ZoomManager;

  constructor() {
    // ------- menus --------
  }

  ngOnInit() {
    this.mode = 'eSelecting';
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
    if (this.zoomManager) {
      this.zoomManager.zoomOut();
    }
  }

  zoomIn() {
    if (this.zoomManager) {
      this.zoomManager.zoomIn();
    }
  }

  zoomFit() {
    if (this.zoomManager) {
      this.zoomManager.resetZoom();
    }
  }

  displayMode(): string {
    switch (this.mode) {
      case 'eAdding':
        return 'Adding';
      case 'eEditing':
        return 'Editing';
    }
  }

  deleteAll(){
    this.onDeleteAll.emit();
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
        this.mode = 'eSelecting';
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
