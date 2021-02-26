import {Shape} from "./shape";

export interface ContextMenuSVGSelectionEvent {
  selectedShapes: Shape[];
  contextMenuTarget: EventTarget;
}
