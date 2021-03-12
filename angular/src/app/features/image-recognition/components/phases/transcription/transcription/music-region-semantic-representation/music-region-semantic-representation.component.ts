import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {ClassifierModel} from "../../../../../../../core/model/entities/classifier-model";

@Component({
  selector: 'app-music-region-semantic-representation',
  templateUrl: './music-region-semantic-representation.component.html',
  styleUrls: ['./music-region-semantic-representation.component.css']
})
export class MusicRegionSemanticRepresentationComponent implements OnInit {
  @Input() semanticClassifiers: Observable<ClassifierModel[]>;

  constructor() { }

  ngOnInit(): void {
  }

  onExecuteClassifier(classifierModel: ClassifierModel) {

  }
}
