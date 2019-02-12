import {Component, ElementRef, OnInit, QueryList, Renderer2, ViewChild, ViewChildren} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Project} from '../model/project';
import {DragulaService} from 'ng2-dragula';
import {ImageThumbnailComponent} from '../image-thumbnail/image-thumbnail.component';
import {NGXLogger} from 'ngx-logger';
import {SessionDataService} from '../services/session-data.service';
import {ComponentCanDeactivate} from '../component-can-deactivate';
import {ProjectStatistics} from '../model/project-statistics';
import {ProjectService} from "../services/project.service";
import {State} from "../model/state";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent extends ComponentCanDeactivate implements OnInit {
  projectStatistics: ProjectStatistics;
  private _projectState: string;
  BAG = 'DRAGULA_FACTS';

  @ViewChildren(ImageThumbnailComponent) imageThumbnailComponents: QueryList<ImageThumbnailComponent>;
  @ViewChild('domImages') domImages: ElementRef;

  constructor(
    private sessionDataService: SessionDataService,
    private route: ActivatedRoute,
    private router: Router,
    private dragulaService: DragulaService,
    private logger: NGXLogger,
    private projectService: ProjectService
  ) {
    super();
    this.logger.debug('Loading project component');
    this.initReorderInteraction();
  }

  ngOnInit() {
    const routeParams = this.route.snapshot.params;

    this.projectService.getProject$(routeParams.id).subscribe(next => this.loadProject(next));
    this.projectService.getProjectStatistics$(routeParams.id).subscribe(next => this.projectStatistics = next);
  }

  private loadProject(loadedProject: Project) {
    this.sessionDataService.loadProject(loadedProject);
    this.project.orderImageArray();
    this.changeProjectState();
  }

  get project(): Project {
    return this.sessionDataService.currentProject;
  }

  get projectState(): string {
    return this._projectState;
  }

  uploadImages() {
    const url = 'uploadimages';
    // Redirect the user
    this.router.navigate([url, this.project.id]);
  }

  canDeactivate(): boolean {
    return false; // TODO
  }

  projectIsLoaded() {
    return this.project != null;
  }

  composerChanged($event) {
    this.projectService.saveProjectComposer(this.project, $event); // if failed, the model object will not change
  }

  commentsChanged($event) {
    this.projectService.saveProjectComments(this.project, $event); // if failed, the model object will not change
  }

  set projectState(value: string) {
    this.projectService.saveProjectState(this.project, value);
  }

  private changeProjectState() {
    if (this.project.state == null) {
      this._projectState = 'none';
    } else {
      this._projectState = this.project.state.state;
    }
  }

  private initReorderInteraction() {
    this.dragulaService.drop(this.BAG)
      .subscribe(({ el }) => {
        // this.logger.debug('Images order for drop ' + el );
        // this.logger.debug('DOM:' + this.domImages.nativeElement);

        let imagesOrder = '';
        let firstImage = true;
        const sortedImages = this.domImages.nativeElement.querySelectorAll('app-image-thumbnail');
        sortedImages.forEach(sortedImage => {
          if (firstImage) {
            firstImage = false;
          } else {
            imagesOrder += ',';
          }
          // sortedImage.dataset['id'] is obtained using the HTML attribute [attr.data-id]="image.id"
          imagesOrder += sortedImage.dataset['id'];
        });

        this.logger.debug('Sorted images ' + imagesOrder);
        this.project.imagesOrdering = imagesOrder;
        this.projectService.updateProject(this.project);
      });
  }

}
