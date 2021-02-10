/**
 * Not using Selection name because it exists in Angular
 */
export class Selections {
  private selectedElements: Set<any>;

  constructor() {
    this.selectedElements = new Set<any>();
  }

  public add(item: any) {
    this.selectedElements.add(item);
  }

  public remove(item: any) {
    this.selectedElements.delete(item);
  }

  public clear() {
    this.selectedElements.forEach(selected => {
      selected.onDeselected.emit();
    });
    this.selectedElements.clear();
  }

  replace(item: any) {
    this.clear();
    this.add(item);
  }
}
