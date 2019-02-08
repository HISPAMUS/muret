import {Directive, Input, ViewContainerRef, OnInit, OnDestroy} from '@angular/core';
import { ShapeComponent } from '../components/shape/shape.component';

@Directive({
    selector: '[appDynamicSVG]'
})

export class DynamicSvgDirective implements OnInit, OnDestroy {

    @Input() appDynamicSVG: ShapeComponent;

    constructor(private viewContainerRef: ViewContainerRef) {
    }

    ngOnInit() {
        /* console.log('DynamicSvgDirective ngOnInit() - component : ',
          this.appDynamicSVG + ' and viewContainerRef=' + this.viewContainerRef
        + ' and shapeComponent=' + this.appDynamicSVG); */

        // const shapeComponent: ShapeComponent = this.shapeService.getShapeComponent();
        // this.viewContainerRef.createEmbeddedView(shapeComponent.shapeTemplate);
        if (this.viewContainerRef) {
          if (this.appDynamicSVG) {
            if (this.appDynamicSVG.shapeTemplate) {
              this.viewContainerRef.createEmbeddedView(this.appDynamicSVG.shapeTemplate);
            } else {
              throw new Error('this.appDynamicSVG.shapeTemplate is null in DynamicSvgDirective (is there a ShapeComponent not created by the ShapeCanvas?');
            }
          } else {
            throw new Error('this.appDynamicSVG is null in DynamicSvgDirective');
          }
        } else {
          throw new Error('this.viewContainerRef is null in DynamicSvgDirective');
        }
    }

    ngOnDestroy() {
        console.log('DynamicSvgDirective ngOnDestroy()');
        this.viewContainerRef.clear();
    }
}

