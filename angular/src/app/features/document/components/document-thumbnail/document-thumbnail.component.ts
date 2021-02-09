import {Component, Input, OnInit} from '@angular/core';
import {Observable, of} from "rxjs";
import {Part} from "../../../../core/model/entities/part";

@Component({
  selector: 'app-document-thumbnail',
  templateUrl: './document-thumbnail.component.html',
  styleUrls: ['./document-thumbnail.component.css']
})
export class DocumentThumbnailComponent implements OnInit {
  @Input() filename: string;
  documentParts$: Observable<Part[]>;
  imagePartIds$: Observable<number[]>; // set of part ids

  constructor() {
    //TODO - de momento - cambiar por petición
    this.documentParts$ = of([
      {
        id: 1,
        name: 'Tiple'
      },
      {
        id: 2,
        name: 'Alto'
      },
      {
        id: 3,
        name: 'Tenor'
      },      {
        id: 4,
        name: 'Bass'
      }
    ]);

    this.imagePartIds$ = of([1,3]);
  }

  ngOnInit(): void {
  }

}
