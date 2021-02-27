import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-document-phases',
  templateUrl: './image-phases.component.html',
  styleUrls: ['./image-phases.component.css']
})
export class ImagePhasesComponent implements OnInit {
  @Input() imageID: number;
  @Input() size: string;

  constructor() { }

  ngOnInit(): void {
  }

}
