import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-previous-image',
  templateUrl: './previous-image.component.html',
  styleUrls: ['./previous-image.component.css']
})
export class PreviousImageComponent implements OnInit {

    @Input() prevImageID: number;

    @Input() selectedPhase: string;

    @Input() size: string;

    constructor() { }

  ngOnInit(): void {
  }

}
