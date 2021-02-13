import {Directive, ElementRef, HostListener, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import { EventEmitter } from '@angular/core';
import {SelectionManager} from './selection-manager';

@Directive({
  selector: '[appSelectable]'
})
export class SelectableDirective implements OnChanges {
  @Input() selection: SelectionManager;
  @Input() modelID: any;
  @Output() onSelected = new EventEmitter(); // emitted by the selection manager on the insertion to the selected set of elements
  @Output() onDeselected = new EventEmitter(); // emitted by the selection manager

  constructor() { // private el: ElementRef el is the element containing the directive
  }

  @HostListener('click', ["$event"])
  onMouseClick() {
    if (!this.selection) {
      throw new Error('The [selection] attribute must be set when using the appSelectable directive');
    }
    // @ts-ignore
    if (event.shiftKey) {
      this.selection.selectRange(this);
      // @ts-ignore
    } else if (event.metaKey) {
      this.selection.addOrRemove(this);
    } else {
      this.selection.replace(this);
    }

    event.stopPropagation();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes.selection.isFirstChange()) {
      if (changes.selection.currentValue instanceof SelectionManager) {
        (changes.selection.currentValue as SelectionManager).addSelectable(this);
      }
    }
  }

  /**
   * It returns the model ID associated to the selectable
   */
  public getSelectedModelID(): any {
    if (!this.modelID) {
      throw new Error('The [modelID] property is not set');
    }
    return this.modelID;
  }

  /*@HostListener('mouseenter', ["$event"])
  onMouseEnter() {
    if (!this.selectableContainer) {
      throw new Error('The selectableContainer must be set when using the appSelectable directive');
    }
    if (this.selectableContainer.isSelectingWithDrag()) {
      this.selectableContainer.onSelect(this);
      event.stopPropagation();
    }
  }

  private doSelect() {
    if (!this.onSelected) {
      throw new Error('The [onSelected] attribute must be set when using the appSelectable directive');
    }
    this.onSelected.emit();
  }

  private doDeselect() {
    if (!this.onDeselected) {
      throw new Error('The [onDeselected] attribute must be set when using the appSelectable directive');
    }
    this.onDeselected.emit();
  }*/
}
