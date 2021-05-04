import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-next-image',
  templateUrl: './next-image.component.html',
  styleUrls: ['./next-image.component.css']
})
export class NextImageComponent implements OnInit {

    @Input() nextImageID: number;

    @Input() selectedPhase: string;

    @Input() size: string;

    constructor() { }

  ngOnInit(): void {
  }

}
