import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-semantic-representation',
  templateUrl: './semantic-representation.component.html',
  styleUrls: ['./semantic-representation.component.css']
})
export class SemanticRepresentationComponent implements OnInit {

  imageID: number;

  constructor(private router: Router) { }

  ngOnInit() {
    // TODO
    this.imageID = 0;
  }

  openDocumentAnalysis() {
    this.router.navigate(['documentanalysis', this.imageID]);
  }

  openAgnosticRepresentation() {
    this.router.navigate(['agnosticrepresentation', this.imageID]);
  }
}
