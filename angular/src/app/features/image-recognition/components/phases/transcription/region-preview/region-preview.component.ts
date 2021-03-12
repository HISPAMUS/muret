import {Component, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {ClassifierModel} from "../../../../../../core/model/entities/classifier-model";

@Component({
  selector: 'app-region-preview',
  templateUrl: './region-preview.component.html',
  styleUrls: ['./region-preview.component.css']
})
export class RegionPreviewComponent implements OnInit {
  @Input() agnosticSymbolClassifiers: Observable<ClassifierModel[]>;

  constructor() { }

  ngOnInit(): void {
  }

  onExecuteClassifier(classifierModel: ClassifierModel) {

  }
}
