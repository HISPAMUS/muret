import {Directive, ElementRef, HostListener, Input, OnInit, Output} from '@angular/core';
import { EventEmitter } from '@angular/core';
import {Selections} from './selections';

@Directive({
  selector: '[appSelectable]'
})
export class SelectableDirective {
  @Input() selection: Selections;
  @Output() onSelected = new EventEmitter();
  @Output() onDeselected = new EventEmitter();

  constructor(private el: ElementRef) { // el is the element containing the directive
  }

  @HostListener('click', ["$event"])
  onMouseClick() {
    if (!this.selection) {
      throw new Error('The [selection] attribute must be set when using the appSelectable directive');
    }
    // @ts-ignore
    if (event.shiftKey) {
      this.selection.add(this);
    } else {
      this.selection.replace(this);
    }

    this.onSelected.emit();
    event.stopPropagation();
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
