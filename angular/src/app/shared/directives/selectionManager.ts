/**
 * Not using Selection name because it exists in Angular
 */
export class SelectionManager {
  private selectedElements: Set<any>;
  private _selectableElements: any[]; // optional - in order to be able to select with shift key from an element to another one
  private lastSelectedElementIndex: number = 0;

  constructor() {
    this.selectedElements = new Set<any>();
    this._selectableElements = [];
  }

  get selectableElements() {
    return this._selectableElements;
  }

  public addOrRemove(item: any) {
    debugger;
    if (this.selectedElements.has(item)) {
      this.remove(item);
    } else {
      this._add(item);
    }
    this.lastSelectedElementIndex = this._selectableElements.indexOf(item);
  }

  public _add(item: any) {
    this.selectedElements.add(item);
    item.onSelected.emit();
  }

  public remove(item: any) {
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

  replace(item: any) {
    this.clear();
    this.addOrRemove(item);
  }

  public selectRange(to: any) {
    let indexTo = this._selectableElements.indexOf(to);
    if (indexTo !== -1) {
      if (indexTo < this.lastSelectedElementIndex) { // if selection from an element previous than the selected one
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

  public addSelectable(el: any) {
    this._selectableElements.push(el);
  }
}
