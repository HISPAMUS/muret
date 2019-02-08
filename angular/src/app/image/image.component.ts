import {AfterViewInit, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {NGXLogger} from 'ngx-logger';
// import {ResizedEvent} from 'angular-resize-event/resized-event';
import {ComponentCanDeactivate} from '../component-can-deactivate';
import {ImageToolBarService} from '../image-tool-bar/image-tool-bar.service';
import {DocumentAnalysisViewComponent} from '../document-analysis-view/document-analysis-view.component';
import {SVGMousePositionEvent} from '../svgcanvas/components/svgcanvas/svgcanvas.component';

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.css']
})

export class ImageComponent extends ComponentCanDeactivate implements OnInit, AfterViewInit {
  @ViewChild('appDocumentAnalysisView') documentAnalysisView: DocumentAnalysisViewComponent;

  constructor(
    private route: ActivatedRoute,
    private logger: NGXLogger,
    private toolbarService: ImageToolBarService
  ) {
    super();
  }

  ngOnInit() {
  }

  private initToolBarInteraction() {
    this.logger.info('Initiating image tool bar interaction');
    // this way, when a new image is opened, despite the previous selected mode, the documentAnalysis is selected
    this.toolbarService.currentActivePanel = 'documentAnalysisMode';

    this.activateEditMode();

    this.toolbarService.selectedTool$.subscribe(next => {
      switch (next) {
        case '101': // select
          this.activateEditMode();
          break;
        case '102': // split pages
          this.documentAnalysisView.activatePageSplitMode();
          break;
        case '103':  // split regions
          this.documentAnalysisView.activateRegionSplitMode();
          break;
      }
    });
  }

  private activateEditMode() {
    if (this.toolbarService.selectedTool !== '101') {
      this.toolbarService.selectedTool = '101';
      this.documentAnalysisView.activateEditMode();
    }
  }


  public ngAfterViewInit(): void {
    this.logger.debug('ngAfterViewInit');
    this.initToolBarInteraction();
    this.toolbarService.clearDocumentAnalysisEvent.subscribe(next => {
      this.clearDocumentAnalysis();
    });
  }

  /* It draws the page and region bounding boxes */
  /* private setImage(serviceImage: Image) {
    this.image = serviceImage;
    this.logger.debug('Setting image ' + serviceImage + ' ' + this.image.filename);
    this.imageURL = this.projectURLs + '/' + this.image.filename;
  } */

  canDeactivate(): boolean {
    return false; // TODO
  }

  clearDocumentAnalysis() {
    if (confirm('Do you really want to clear the document analysis?')) {
      this.documentAnalysisView.clearDocumentAnalysis();
    }
  }
  onMouseEvent($event: SVGMousePositionEvent) {
  }
}
