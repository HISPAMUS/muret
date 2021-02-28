import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-progress-status',
  templateUrl: './progress-status.component.html',
  styleUrls: ['./progress-status.component.css']
})
export class ProgressStatusComponent implements OnInit {
  private _status: 'hidden' | 'working' | 'done';
  @Output() statusChange = new EventEmitter<'hidden' | 'working' | 'done'>();

  constructor() {
    // ------- menus --------
  }

  ngOnInit() {
  }

  @Input()
  get status() {
    return this._status;
  }

  set mode(val) {
    if (this._status !== val) {
      this._status = val;
      this.statusChange.emit(this._status);
    }
  }
}
