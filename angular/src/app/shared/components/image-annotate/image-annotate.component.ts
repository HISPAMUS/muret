import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Shape} from '../../../svg/model/shape';

/**
 * The image to be tagged is loaded as part of the SVG. The default viewPort of the SVG is 0 0 imageWidth imageHeight, that means that
 * the SVG is resized to fit the image. By changing the widthPercentage and heightPercentage values of the SVG the zoom is changed
 */
@Component({
  selector: 'app-image-annotate',
  templateUrl: './image-annotate.component.html',
  styleUrls: ['./image-annotate.component.css']
})
export class ImageAnnotateComponent implements OnInit {
  @Input() imageURL: string;
  @Input() backgroundImageWidth: number;
  @Input() backgroundImageHeight: number;

  @Input() layers: string[];
  @Input() shapes: Shape[];

  canvasHeightPercentage: number;  // e.g. 100 for 100%
  canvasWidthPercentage: number;
  zoomFactor = 1;

  checkboxGroupForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.checkboxGroupForm = this.formBuilder.group({
      left: true,
      middle: false,
      right: false
    });
  }

  ngOnInit() {
    this.computeZoom();
  }

  zoomIn() {
    this.zoomFactor += 0.5;
    this.computeZoom();
  }

  zoomOut() {
    this.zoomFactor = Math.max(1, this.zoomFactor - 0.5);
    this.computeZoom();
  }

  zoomFit() {
    this.zoomFactor = 1;
    this.computeZoom();
  }

  private computeZoom() {
    this.canvasHeightPercentage = 100.0 * this.zoomFactor;
    this.canvasWidthPercentage = 100.0 * this.zoomFactor;
  }
}
