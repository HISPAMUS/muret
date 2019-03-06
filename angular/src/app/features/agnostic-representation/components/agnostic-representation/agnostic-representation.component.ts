import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {Shape} from '../../../../svg/model/shape';

@Component({
  selector: 'app-agnostic-representation',
  templateUrl: './agnostic-representation.component.html',
  styleUrls: ['./agnostic-representation.component.css']
})
export class AgnosticRepresentationComponent implements OnInit {
  imageID: number;
  imageWidth$: Observable<number>;
  imageHeight$: Observable<number>;
  filename$: Observable<string>;
  imageURL$: Observable<string>;
  imagePreviewShapes: Shape[];
  imagePreviewZoomFactor = 1;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    // request store data
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.imageID = +params.get('id'); // + converts the string to number
    });
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openSemanticRepresentation() {
    this.router.navigate(['semanticrepresentation', this.imageID]);
  }

  onPreviewImageShapeSelected($event: Shape) {
  }

  onPreviewImageShapeDeselected($event: Shape) {
  }
}
