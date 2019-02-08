import {Component, Input, OnInit} from '@angular/core';
import {State} from '../model/state';

@Component({
  selector: 'app-state',
  templateUrl: './state.component.html',
  styleUrls: ['./state.component.css']
})
export class StateComponent implements OnInit {
  @Input() state: State;

  constructor() { }

  ngOnInit() {
  }

  showEdit() {
    return this.state && this.state.state === 'inprogress';
  }

  showCheck() {
    return this.state && this.state.state === 'done';
  }

  showDoubleCheck() {
    return this.state && this.state.state === 'doublechecked';
  }

  getTooltip() {
    if (this.state) {
      return this.state.comments;
    } else {
      return '';
    }
  }
}
