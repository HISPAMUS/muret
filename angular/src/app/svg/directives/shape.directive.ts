import {Directive, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appShape]'
})
export class ShapeDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
