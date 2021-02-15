/**
 * Not using Selection name because it exists in Angular
 */
import {SelectableDirective} from "./selectable.directive";

export class SelectionManager {
  private selectedElements: Set<SelectableDirective>;
  private _selectableElements: SelectableDirective[]; // in orderEntities to be able to select with shift key from an element to another one
  private lastSelectedElementIndex: number = 0;

  constructor() {
    this.selectedElements = new Set<any>();
    this._selectableElements = [];
  }

  get selectableElements() {
    return this._selectableElements;
  }

  public addOrRemove(item: SelectableDirective) {
    if (this.selectedElements.has(item)) {
      this.remove(item);
    } else {
      this._add(item);
    }
    this.lastSelectedElementIndex = this._selectableElements.indexOf(item);
  }

  _add(item: SelectableDirective) {
    this.selectedElements.add(item);
    item.onSelected.emit();
  }

  public remove(item: SelectableDirective) {
    this.selectedElements.delete(item);
    item.onDeselected.emit();
  }

  public clear() {
    this.selectedElements.forEach(selected => {
      selected.onDeselected.emit();
    });
    this.selectedElements.clear();
    this.lastSelectedElementIndex = 0;
  }

  public replace(item: SelectableDirective) {
    this.clear();
    this.addOrRemove(item);
  }

  public selectRange(to: SelectableDirective) {
    let indexTo = this._selectableElements.indexOf(to);
    if (indexTo !== -1) {
      if (indexTo < this.lastSelectedElementIndex) { // if selectionManager from an element previous than the selected one
        const aux = indexTo;
        indexTo = this.lastSelectedElementIndex;
        this.lastSelectedElementIndex = aux;
      }
      for (let i = this.lastSelectedElementIndex; i<=indexTo; i++) {
        this._add(this._selectableElements[i]);
      }
      this.lastSelectedElementIndex = indexTo;
    }
  }

  public addSelectable(el: SelectableDirective) {
    this._selectableElements.push(el);
  }

  getSelected(): SelectableDirective[] { // use a copy of the collection to avoid manipulating from outside
    return Array.from(this.selectedElements);
  }
}
