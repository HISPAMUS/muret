import {Component, ElementRef, OnInit, QueryList, Renderer2, ViewChild, ViewChildren} from '@angular/core';
import {Im3wsService} from '../services/im3ws.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Project} from '../model/project';
import {ProjectURLS} from '../model/project-urls';
import {DragulaService} from 'ng2-dragula';
import {ImageThumbnailComponent} from '../image-thumbnail/image-thumbnail.component';
import {NGXLogger} from 'ngx-logger';
import {SessionDataService} from '../session-data.service';
import {ComponentCanDeactivate} from '../component-can-deactivate';
import {ProjectStatistics} from '../model/project-statistics';
// import { Lightbox } from 'ngx-lightbox';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent extends ComponentCanDeactivate implements OnInit {
  project: Project;
  projectURLs: ProjectURLS;
  projectStatistics: ProjectStatistics;

  BAG = 'DRAGULA_FACTS';
  @ViewChildren(ImageThumbnailComponent) imageThumbnailComponents: QueryList<ImageThumbnailComponent>;
  @ViewChild('domImages') domImages: ElementRef;
  private _projectState: string;

  constructor(
    private im3wsService: Im3wsService,
    private sessionDataService: SessionDataService,
    private route: ActivatedRoute,
    private router: Router,
    private dragulaService: DragulaService,
    private logger: NGXLogger
  ) {
    super();
    this.logger.debug('Loading project component');
    dragulaService.drop(this.BAG)
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
        this.logger.debug('Updating project ' + imagesOrder);
        im3wsService.projectService.saveProject(this.project);
        this.logger.debug('Project updated');
        /*
          this.imageThumbnailComponents.forEach((item: ImageThumbnailComponent) =>
            this.logger..debug('Image ID ' + item.image.id));*/
      });
  }

  ngOnInit() {
    const routeParams = this.route.snapshot.params;

    this.im3wsService.projectService.getProjectURLs$(routeParams.id)
      .subscribe(result => this.projectURLs = result).add(teardown => {
      this.logger.debug('Project URLs: ' + this.projectURLs);

      this.logger.debug('Loading project ...'); // after urls have been obtained
      this.im3wsService.projectService.getProject$(routeParams.id)
        .subscribe(res =>
          this.project = Object.assign(new Project(), res))
        .add(teardown2 => {
          this.logger.debug('Project component ' + this.project.name + ' with #' + this.project.images.length + ' images');
          this.project.orderImageArray();
          this.changeProjectState();
          this.sessionDataService.currentProject = this.project;
        });
    });

    this.im3wsService.projectService.getProjectStatistics$(routeParams.id)
      .subscribe(result => this.projectStatistics = result);
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
    this.logger.info('Saving project after composer change ' + $event);
    this.project.composer = $event;
    this.im3wsService.projectService.saveProjectComposer(this.project);
  }

  commentsChanged($event) {
    this.logger.info('Saving project after comments change ' + $event);
    this.project.comments = $event;
    this.im3wsService.projectService.saveProjectComments(this.project);
  }


  get projectState(): string {
    return this._projectState;
  }

  set projectState(value: string) {
    this.logger.debug('Changing project state to ' + value);

    if (value === 'none') {
      this.project.state = null;
    } else {
      this.project.state.state = value;
    }
    this.im3wsService.projectService.saveProjectState(this.project);

    this._projectState = value;

  }

  private changeProjectState() {
    if (this.project.state == null) {
      this._projectState = 'none';
    } else {
      this._projectState = this.project.state.state;
    }
  }
}
