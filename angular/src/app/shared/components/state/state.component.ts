import {Component, Input, OnInit} from '@angular/core';
import {State} from '../../../core/model/entities/state';

/** Deprecated **/
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

  getTooltip() {
    if (this.state) {
      return this.state.comments;
    } else {
      return '';
    }
  }
}
