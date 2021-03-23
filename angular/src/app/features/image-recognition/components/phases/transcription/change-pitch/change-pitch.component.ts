import {Component, OnInit, EventEmitter, Output, HostListener} from '@angular/core';

@Component({
  selector: 'app-change-pitch',
  templateUrl: './change-pitch.component.html',
  styleUrls: ['./change-pitch.component.css']
})
export class ChangePitchComponent implements OnInit {
  @Output() onChangeLineSpace = new EventEmitter<string>();
  @Output() onMovePitch = new EventEmitter<number>();

  lines = ['L5', 'L4', 'L3', 'L2', 'L1'];
  spaces = ['S4', 'S3', 'S2', 'S1'];

  constructor() { }

  ngOnInit(): void {
  }

  movePitchDown() {
    this.movePitch(-1);
  }

  movePitchUp() {
    this.movePitch(+1);
  }

  changeLineSpace(linespace: string) {
    this.onChangeLineSpace.emit(linespace);
  }

  private movePitch(displacement: number) {
    this.onMovePitch.emit(displacement);
  }

 /* @HostListener('window:keydown', ['$event']) // keydown to prevent scroll
  keyEvent(event: KeyboardEvent) {
      switch (event.code) {
        case 'ArrowDown':
          event.stopImmediatePropagation();
          event.preventDefault(); // prevent scroll
          this.movePitchDown();
          break;
        case 'ArrowUp':
          event.stopImmediatePropagation();
          event.preventDefault(); // prevent scroll
          this.movePitchUp();
          break;
      }
  }*/
}
