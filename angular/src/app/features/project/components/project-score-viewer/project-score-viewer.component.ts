import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {ExportMEI, ExportMEIPartsFacsimile, ExportMensurstrich, ExportMusicXML, GetProject} from '../../store/actions/project.actions';
import {selectProject, selectProjectMEI} from '../../store/selectors/project.selector';
import {Observable, Subscription} from 'rxjs';
import {NotationService} from '../../../semantic-representation/services/notation.service';
import { saveAs } from 'file-saver';
import {Project} from '../../../../core/model/entities/project';

@Component({
  selector: 'app-project-score-viewer',
  templateUrl: './project-score-viewer.component.html',
  styleUrls: ['./project-score-viewer.component.css']
})
export class ProjectScoreViewerComponent implements OnInit, OnDestroy {
  private projectID: number;
  private meiSubscription: Subscription;
  notationAsSVG: any;
  private mei: string;
  project$: Observable<Project>;

  // don't use here REDUX for the FileUploader
  constructor(private route: ActivatedRoute, private router: Router, private store: Store<ProjectState>,
              private notationService: NotationService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.projectID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetProject(this.projectID));
      /// this.store.dispatch(new GetProjectParts(this.projectID));
    });

    this.project$ = this.store.select(selectProject);

    this.meiSubscription = this.store.select(selectProjectMEI).subscribe(next => {
      this.notationAsSVG = this.notationService.renderScore(next);
      this.mei = next;
    });
  }

  ngOnDestroy(): void {
    this.meiSubscription.unsubscribe();
  }

  saveFile() {
    const headers = new Headers();
    headers.append('Accept', 'text/plain');
    this.saveToFileSystem(this.mei);
  }

  private saveToFileSystem(mei: string) {
    const blob = new Blob([mei], { type: 'text/plain' });
    saveAs(blob, 'export_' + this.projectID + '.mei');
  }

  renderFullScore() {
    this.store.dispatch(new ExportMEI(this.projectID, null));
  }

  render(partID: number) {
    this.store.dispatch(new ExportMEI(this.projectID, partID));
  }

  exportPartsAndFacsimile() {
    this.store.dispatch(new ExportMEIPartsFacsimile(this.projectID));
  }

  exportFullMensurstrich() {
    this.store.dispatch(new ExportMensurstrich(this.projectID));
  }

  exportMusicXML() {
    this.store.dispatch(new ExportMusicXML(this.projectID));
  }
}
