import {Component, ElementRef, OnInit, QueryList, Renderer2, ViewChild, ViewChildren} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Project} from '../../model/project';
import {DragulaService} from 'ng2-dragula';
import {ImageThumbnailComponent} from '../../projects/components/image-thumbnail/image-thumbnail.component';
import {NGXLogger} from 'ngx-logger';
import {SessionDataService} from '../../services/session-data.service';
import {ComponentCanDeactivate} from '../../routing/component-can-deactivate';
import {ProjectStatistics} from '../../model/project-statistics';
import {ProjectCrudService} from "../../services/crud/project-crud.service";
import {State} from "../../model/state";
import {ProjectService} from "../../services/businesslogic/project.service";
import {Image} from "../../model/image";

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
    private projectService: ProjectService,
    private projectCrudService: ProjectCrudService //TODO Quitar
  ) {
    super();
    this.logger.debug('Loading project component');
    this.initReorderInteraction();
  }

  ngOnInit() {
    const routeParams = this.route.snapshot.params;

    this.projectCrudService.getProject$(routeParams.id).subscribe(next => this.loadProject(next));
    this.projectService.getProjectStatistics$(routeParams.id).subscribe(next => this.projectStatistics = next);
  }

  private loadProject(loadedProject: Project) {
    this.sessionDataService.loadProject(loadedProject);
    this.orderImageArray();
    this.changeProjectState();
  }

  //TODO Esto debe estar en un servicio, no en un componente
  private orderImageArray() {
    if (this.project.images) {
      // first insert input images in a map
      const imagesMap: Map<number, Image> = new Map<number, Image>();
      this.project.images.forEach(image => {
        imagesMap.set(image.id, image);
      });

      const newImages = new Array<Image>();
      // insert images as appear on the imagesOrdering
      if (this.project.imagesOrdering) {
        this.project.images = new Array<Image>();
        const imageOrders = this.project.imagesOrdering.split(',');
        imageOrders.forEach(order => {
          const imageId = Number(order);
          const image = imagesMap.get(imageId);
          if (image) { // if not something may go wrong but it is not important here
            newImages.push(image);
            imagesMap.delete(imageId);
          }
        });
      } else {
        this.project.imagesOrdering = '';
      }

      // now insert the other images not inserted yet
      imagesMap.forEach((value: Image, key: number) => {
        if (this.project.imagesOrdering.length > 0) {
          this.project.imagesOrdering += ',';
        }
        this.project.imagesOrdering += key;
        newImages.push(value);
      });
      this.project.images = newImages;
    }
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
    this.projectCrudService.saveProjectComposer(this.project, $event); // if failed, the model object will not change
  }

  commentsChanged($event) {
    this.projectCrudService.saveProjectComments(this.project, $event); // if failed, the model object will not change
  }

  set projectState(value: string) {
    this.projectCrudService.saveProjectState(this.project, value);
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
        this.projectCrudService.updateProject(this.project);
      });
  }

}
