import { Component, OnInit } from '@angular/core';
import {ImageRecognitionBaseAbstractComponentComponent} from "../image-recognition-base-abstract-component/image-recognition-base-abstract-component.component";

@Component({
  selector: 'app-image-overview',
  templateUrl: './image-overview.component.html',
  styleUrls: ['./image-overview.component.css']
})
export class ImageOverviewComponent extends ImageRecognitionBaseAbstractComponentComponent implements OnInit{


}
