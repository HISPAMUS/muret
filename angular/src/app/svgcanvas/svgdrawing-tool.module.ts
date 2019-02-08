import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RectangleComponent} from './components/rectangle/rectangle.component';
import {LineComponent} from './components/line/line.component';
import {PathComponent} from './components/path/path.component';
import {DynamicSvgDirective} from './directives/dynamic-svg.directive';
import { SVGDrawingComponent } from '../svgdrawing/svgdrawing.component';
import {CircleComponent} from './components/circle/circle.component';
import {ShapeComponent} from './components/shape/shape.component';
import {SquareComponent} from './components/square/square.component';
import {EllipseComponent} from './components/ellipse/ellipse.component';
import {TextComponent} from './components/text/text.component';
import {GroupComponent} from './components/group/group.component';
import {ImageComponent} from './components/image/image.component';
import {PolyLineComponent} from './components/polyline/polyline.component';
import {DynamicFieldDirective} from './directives/dynamic-field.directive';
import {DynamicFormComponent} from './components/dynamic-form/dynamic-form.component';
import {CheckboxComponent} from './control/checkbox/checkbox.component';
import {InputComponent} from './control/input/input.component';
import {RadiobuttonComponent} from './control/radiobutton/radiobutton.component';
import {SelectComponent} from './control/select/select.component';
import {ColorPickerComponent} from './control/color-picker/color-picker.component';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ColorPickerModule } from 'ngx-color-picker';
import { SVGCanvasComponent } from './components/svgcanvas/svgcanvas.component';
import { FreehandComponent } from './components/freehand/freehand.component';

/**
 * Adapted from: https://github.com/johandb/svg-drawing-tool
 */
@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    ColorPickerModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SVGCanvasComponent
  ],
  declarations: [
    SVGDrawingComponent,
    LineComponent,
    CircleComponent,
    RectangleComponent,
    DynamicSvgDirective,
    ShapeComponent,
    SquareComponent,
    EllipseComponent,
    TextComponent,
    GroupComponent,
    ImageComponent,
    PolyLineComponent,
    PathComponent,
    DynamicFieldDirective,
    DynamicFormComponent,
    CheckboxComponent,
    InputComponent,
    RadiobuttonComponent,
    SelectComponent,
    ColorPickerComponent,
    SVGCanvasComponent,
    FreehandComponent
  ],
  entryComponents: [
    ShapeComponent,
    LineComponent,
    CircleComponent,
    RectangleComponent,
    SquareComponent,
    EllipseComponent,
    TextComponent,
    GroupComponent,
    ImageComponent,
    PolyLineComponent,
    PathComponent,
    InputComponent,
    SelectComponent,
    CheckboxComponent,
    RadiobuttonComponent,
    FreehandComponent
  ],
  providers: [
  ],
  bootstrap: [SVGDrawingComponent]
})
export class SVGDrawingToolModule { }
