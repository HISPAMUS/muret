/**
 * Based on SelectionManager, used just for SVG
 */
import {Shape} from "./shape";

export class SVGSelectionManager {
  private selectedElements: Set<Shape>;
  private _selectableElements: Shape[]; // in orderEntities to be able to select with shift key from an element to another one
  private lastSelectedElementIndex: number = 0;
  private _selectByX: boolean; // if false, it will select using first the y

  constructor() {
    this.selectedElements = new Set<any>();
    this._selectableElements = [];
  }


  get selectByX(): boolean {
    return this._selectByX;
  }

  set selectByX(value: boolean) {
    this._selectByX = value;
    if (this._selectableElements) {
      this.selectableElements = this._selectableElements; // invoke sort again
    }
  }

  get selectableElements() {
    return this._selectableElements;
  }

  public addOrRemove(item: Shape) {
    if (this.selectedElements.has(item)) {
      this.remove(item);
    } else {
      this.add(item);
    }
  }

  public addAll(shapes: Shape[]) {
    if (shapes) {
      shapes.forEach(shape => {
        this.add(shape);
      });
    }
  }

  public add(item: Shape) {
    this.selectedElements.add(item);
    item.highlightSelected();
    this.lastSelectedElementIndex = this._selectableElements.indexOf(item);

    //item.onSelected.emit();
  }

  public remove(item: Shape) {
    this.selectedElements.delete(item);
    item.unHighlightSelected();
    //item.onDeselected.emit();
  }

  public clear() {
    this.selectedElements.forEach(selected => {
      selected.unHighlightSelected();
    });
    this.selectedElements.clear();
    this.lastSelectedElementIndex = 0;
  }

  public replace(item: Shape) {
    this.clear();
    this.addOrRemove(item);
  }

  public selectRange(to: Shape) {
    let indexTo = this._selectableElements.indexOf(to);
    if (indexTo !== -1) {
      if (indexTo < this.lastSelectedElementIndex) { // if selectionManager from an element previous than the selected one
        const aux = indexTo;
        indexTo = this.lastSelectedElementIndex;
        this.lastSelectedElementIndex = aux;
      }
      for (let i = this.lastSelectedElementIndex; i<=indexTo; i++) {
        const e = this._selectableElements[i];
        if (e.selectable && !e.hidden) {
          this.add(this._selectableElements[i]);
        }
      }
      this.lastSelectedElementIndex = indexTo;
    }
  }


  set selectableElements(value: Shape[]) {
    this._selectableElements = value.sort((a,b) => {
      if (this._selectByX) {
        if (a.fromX < b.fromX) {
          return -1;
        } else if (a.fromX > b.fromX) {
          return 1;
        } else {
          if (a.fromY < b.fromY) {
            return -1;
          } else if (a.fromY > b.fromY) {
            return 1;
          } else {
            if (!a.id || !b.id) {
              throw new Error('Missing id in shape');
            }
            return a.id.localeCompare(b.id);
          }
        }
      } else {
        if (a.fromY < b.fromY) {
          return -1;
        } else if (a.fromY > b.fromY) {
          return 1;
        } else {
          if (a.fromX < b.fromX) {
            return -1;
          } else if (a.fromX > b.fromX) {
            return 1;
          } else {
            if (!a.id || !b.id) {
              throw new Error('Missing id in shape');
            }
            return a.id.localeCompare(b.id);
          }
        }
      }
    });
  }

  public getSelected(): Shape[] { // use a copy of the collection to avoid manipulating from outside
    return Array.from(this.selectedElements);
  }

  public isSelected(shape: Shape): boolean {
    return this.selectedElements.has(shape);
  }

  public hasSelectedShapes(): boolean {
    return this.selectedElements.size > 0;
  }

  public hasJustOneSelectedShape(): boolean {
    return this.selectedElements.size == 1;
  }

  public leaveJustOneSelected() {
    if (this.selectedElements.size > 1) {
      const first = this.selectedElements.values().next().value;
      this.replace(first);
    }
  }

}
