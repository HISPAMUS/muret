import {Component, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {ShapeProperties} from '../svgcanvas/model/shape';
import {SVGCanvasComponent, SVGCanvasState} from '../svgcanvas/components/svgcanvas/svgcanvas.component';


@Component({
  selector: 'app-svgdrawing-component',
  templateUrl: './svgdrawing.component.html',
  styleUrls: ['./svgdrawing.component.css']
})
export class SVGDrawingComponent implements OnInit, OnChanges {
  title = 'SVG Drawing Tool';

  @ViewChild('svgCanvas') svgCanvas: SVGCanvasComponent;

  shapeProperties: ShapeProperties = new ShapeProperties();
  shapeValue: string;

  constructor() {
    console.log('SVGDrawing constructor');
  }

  ngOnInit(): void {
    console.log('svgCanvas = ' + this.svgCanvas);
  }

  clearShapes(): void {
    this.svgCanvas.clear();
  }

  selectTool(toolType: string): void {
    if (toolType === 'Pointer') {
      this.svgCanvas.changeState(SVGCanvasState.eSelecting);
    } else if (toolType === 'Move') {
      this.svgCanvas.changeState(SVGCanvasState.eEditing);
    }
    console.log('selected tool:', toolType);
  }

  selectShape(shapeType$: any) {
    this.svgCanvas.selectShape(shapeType$);
  }

  ngOnChanges(changes: SimpleChanges): void {
  }

}
