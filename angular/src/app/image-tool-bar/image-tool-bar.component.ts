import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ImageToolBarService} from './image-tool-bar.service';
import {NgbPanelChangeEvent} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';
import {NGXLogger} from 'ngx-logger';
import {SessionDataService} from '../services/session-data.service';

@Component({
  selector: 'app-image-tool-bar',
  templateUrl: './image-tool-bar.component.html',
  styleUrls: ['./image-tool-bar.component.css']
})
export class ImageToolBarComponent implements OnInit {
  constructor(private currentSession: SessionDataService, private toolbarService: ImageToolBarService, private router: Router, private logger: NGXLogger) { }

  ngOnInit() {
  }

  getCurrentProjectName(): string {
    return this.currentSession.currentProject.name;
  }

  onBrowseCurrentProject() {
    this.router.navigate(['/project/' + this.currentSession.currentProject.id]);
  }

  get selectedTool(): string {
    return this.toolbarService.selectedTool;
  }

  set selectedTool(value: string) {
    this.toolbarService.selectedTool = value;
  }


  get currentActivePanel(): string {
    return this.toolbarService.currentActivePanel;
  }

  set currentActivePanel(value: string) {
    this.toolbarService.currentActivePanel = value;
  }

  clearDocumentAnalysis() {
    this.toolbarService.clearDocumentAnalysisEvent.emit();
  }

  onPanelChange($event: NgbPanelChangeEvent) {
    this.logger.debug('Panel change ' + $event.panelId + ', nextState=' + $event.nextState);
    if ($event.nextState) {
      this.toolbarService.currentActivePanel = $event.panelId;
      switch ($event.panelId) {
        case 'documentAnalysisMode':
          this.router.navigate(['/image']);
          break;
        case 'symbolsMode':
          this.router.navigate(['/symbols']);
          break;
      }
    }
  }

}
