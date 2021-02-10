import {Directive, ElementRef, EventEmitter, HostListener, Input, Output} from '@angular/core';

import {Selections} from './selections';

// It contains elements with the appSelectable directive
@Directive({
  selector: '[appSelectableContainer]'
})
export class SelectableContainerDirective {
  @Input() selection: Selections;

  constructor(el: ElementRef) { // el = the element containing the directive
  }

  @HostListener('click', ["$event"])
  onMouseDown() {
    this.selection.clear();
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
    if (!this.selection) {
      throw new Error('[selection] attribute is required for the appSelectable directive');
    }
    this.selection.add(item);
  }

  public startSelectingWithDrag() {
    this.selectingWithDrag = true;
  }

  public stopSelectingWithDrag() {
    this.selectingWithDrag = false;
  }*/
}
