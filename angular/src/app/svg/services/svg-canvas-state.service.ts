import {Injectable, Type} from '@angular/core';

export enum SVGCanvasState {
  eIdle,  eSelecting, eDrawing, eEditing
}

@Injectable() // provided locally (sandboxing) - see https://angular.io/guide/dependency-injection-in-action
export class SvgCanvasStateService {
  // used to communicate states
  // see http://jasonwatmore.com/post/2019/02/07/angular-7-communicating-between-components-with-observable-subject
  // private subject = new Subject<SVGCanvasState>();

  private currentState: SVGCanvasState;
  constructor() { }

  public requestStateChange(newState: SVGCanvasState): SVGCanvasState {
    const prevState = this.currentState;
    // WISH check valid transitions
    this.currentState = newState;
    // this.subject.next(this.currentState); // message just sent on actual state change
    return this.currentState;
  }

  public getState(): SVGCanvasState {
    return this.currentState;
  }

  /*public getState$(): Observable<SVGCanvasState> { // recall to unsubscribe from the component
    return this.subject.asObservable();
  }*/

}
