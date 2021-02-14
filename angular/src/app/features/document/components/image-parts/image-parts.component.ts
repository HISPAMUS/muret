import {Component, Input, OnInit} from '@angular/core';
import {Part} from "../../../../core/model/entities/part";

@Component({
  selector: 'app-image-parts',
  templateUrl: './image-parts.component.html',
  styleUrls: ['./image-parts.component.css']
})
export class ImagePartsComponent implements OnInit {
  @Input() documentParts: Part[];
  @Input() imagePartIds: number[]; // set of part IDS

  constructor() { }

  ngOnInit(): void {
  }

  partTracking(index, item): number {
    return index;
  }

  getText(part: Part): string {
    if (this.imagePartIds && this.imagePartIds.includes(part.id)) {
      return part.name;
    } else {
      return '-';
    }
  }
}
