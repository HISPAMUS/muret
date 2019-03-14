import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SvgCanvasComponent } from './components/svg-canvas/svg-canvas.component';
import { ShapeComponent } from './components/shape/shape.component';
import { RectangleComponent } from './components/rectangle/rectangle.component';
import { LineComponent } from './components/line/line.component';
import { TextComponent } from './components/text/text.component';
import { PathComponent } from './components/path/path.component';
import {DragDropModule} from '@angular/cdk/drag-drop';

@NgModule({
  declarations: [SvgCanvasComponent, ShapeComponent, RectangleComponent, LineComponent, TextComponent, PathComponent],
  imports: [
    CommonModule,
    DragDropModule,
  ], exports: [
    SvgCanvasComponent
  ],
  entryComponents: [ RectangleComponent, LineComponent, TextComponent, PathComponent ]
})
export class SvgModule { }
