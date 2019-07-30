import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Image} from '../../../../core/model/entities/image';
import {Observable} from 'rxjs';
import {Project} from '../../../../core/model/entities/project';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {selectImages, selectProject} from '../../store/selectors/project.selector';
import {GetImages, GetProject} from '../../store/actions/project.actions';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
})
export class ProjectComponent implements OnInit {
  project$: Observable<Project>;
  images$: Observable<Image[]>;
  private projectID: number;

  constructor(private route: ActivatedRoute, private store: Store<ProjectState>, private router: Router) {
    this.project$ = this.store.select(selectProject);
    this.images$ = this.store.select(selectImages);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.projectID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetProject(this.projectID));
      this.store.dispatch(new GetImages(this.projectID));
      setTimeout( () => { // setTimeout solves the ExpressionChangedAfterItHasBeenCheckedError:  error
        this.store.dispatch(new ActivateLink({title: 'Project ', routerLink: 'project/' + this.projectID}));
      });
    });
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }

  uploadImages() {
    this.router.navigate(['/project/uploadImages', this.projectID]);
  }

  viewFullScore() {
    this.router.navigate(['/project/scoreView', this.projectID]);
  }
}
