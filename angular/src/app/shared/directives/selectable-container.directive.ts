import {Directive, ElementRef, EventEmitter, HostListener, Input, Output} from '@angular/core';

import {SelectionManager} from './selection-manager';

// It contains elements with the appSelectable directive
@Directive({
  selector: '[appSelectableContainer]'
})
export class SelectableContainerDirective {
  @Input() selectionManager: SelectionManager;

  constructor(el: ElementRef) { // el = the element containing the directive
  }

  @HostListener('click', ["$event"])
  onMouseDown() {
    if (this.selectionManager) {
      this.selectionManager.clear();
    }
    //event.stopPropagation();
  }


  /*private selectingWithDrag: boolean; // if selecting with mouse drag

  constructor(el: ElementRef) { // el = the element containing the directive
    this.selectingWithDrag = false;
  }

  @HostListener('mousedown', ["$event"])
  onMouseDown() {
    this.selectingWithDrag = true;
    event.stopPropagation();
  }

  @HostListener('mouseup', ["$event"])
  onMouseUp() {
    this.selectingWithDrag = false;
    event.stopPropagation();
  }

  public isSelectingWithDrag(): boolean {
    return this.selectingWithDrag;
  }

  public onSelect(item: any) {
    if (!this.selectionManager) {
      throw new Error('[selectionManager] attribute is required for the appSelectable directive');
    }
    this.selectionManager.add(item);
  }

  public startSelectingWithDrag() {
    this.selectingWithDrag = true;
  }

  public stopSelectingWithDrag() {
    this.selectingWithDrag = false;
  }*/
}
