import { Component, OnInit } from '@angular/core';
import {ImageRecognitionBaseAbstractComponent} from "../image-recognition-base-abstract/image-recognition-base-abstract.component";

@Component({
  selector: 'app-image-overview',
  templateUrl: './image-overview.component.html',
  styleUrls: ['./image-overview.component.css']
})
export class ImageOverviewComponent extends ImageRecognitionBaseAbstractComponent implements OnInit {
}
