import {Component, OnInit, Self} from '@angular/core';
import {DocumentAnalysisService} from '../document-analysis.service';
import {Observable, of} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {map, switchMap} from 'rxjs/operators';
import {ImageFilesService} from '../../../shared/services/image-files.service';
import {DocumentAnalysisImageProjection} from '../../../shared/projections/document-analysis-image-projection';
import {Rectangle} from '../../../svg/model/rectangle';
import {Line} from '../../../svg/model/line';
import {Text} from '../../../svg/model/text';
import {Path} from '../../../svg/model/path';
import {Shape} from '../../../svg/model/shape';

@Component({
  selector: 'app-document-analysis',
  templateUrl: './document-analysis.component.html',
  styleUrls: ['./document-analysis.component.css'],
  providers: [DocumentAnalysisService]
})
export class DocumentAnalysisComponent implements OnInit {
  documentAnalysisImageProjection$: Observable<DocumentAnalysisImageProjection>;
  loadingImage = 'assets/loading.svg';
  loadedImage$: Observable<string>;
  private shapes: Shape[];
  private imageHeight: number;
  private imageWidth: number;

  constructor(@Self() private documentAnalysisService: DocumentAnalysisService,
              private imageFilesService: ImageFilesService,
              private route: ActivatedRoute) { } // TODO sanitizer al imageFilesService

  ngOnInit() {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.documentAnalysisImageProjection$ = this.documentAnalysisService.getDocumentAnalysisImageProjection$(id);
    this.loadedImage$ = this.documentAnalysisImageProjection$.pipe(
      switchMap(next => {
        return this.readImageContents(next);
      })
    );

    this.shapes = new Array();
    const rect = new Rectangle();
    rect.id = 1;
    rect.fromX = 10;
    rect.fromY = 10;
    rect.width = 1250;
    rect.height  = 1380;
    rect.strokeDashArray = '20';
    rect.fillColor = 'blue';
    rect.strokeColor = 'green';
    rect.strokeWidth = 20;

    this.shapes.push(rect);


    const line = new Line();
    line.id = 2;
    line.fromX = 0;
    line.fromY = 0;
    line.toX = 2965;
    line.toY = 2126;
    line.strokeColor = 'yellow';
    line.strokeWidth = 10;
    this.shapes.push(line);

    const text = new Text();
    text.id = 3;
    text.fromX = 125;
    text.fromY = 123;
    text.text = 'David';
    this.shapes.push(text);

    const path = new Path();
    path.id = 4;
    path.d = 'M150 0 L75 200 L225 200 Z';
    this.shapes.push(path);


    text.fromX = 0;
    text.fromY = 200;

  }

  private readImageContents(documentAnalysisImageProjection: DocumentAnalysisImageProjection) {
    this.imageWidth = documentAnalysisImageProjection.width;
    this.imageHeight = documentAnalysisImageProjection.height;

    return this.imageFilesService.getMasterImageBlob$(documentAnalysisImageProjection.projectPath, documentAnalysisImageProjection.id).
      pipe(map(imageBlob => window.URL.createObjectURL(imageBlob)));
  }
}
