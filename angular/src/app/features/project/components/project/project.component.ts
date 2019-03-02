import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Image} from '../../../../core/model/entities/image';
import {Observable} from 'rxjs';
import {Project} from '../../../../core/model/entities/project';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {selectImages, selectProject} from '../../store/selectors/project.selector';
import {GetImages, GetProject} from '../../store/actions/project.actions';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
})
export class ProjectComponent implements OnInit {
  project$: Observable<Project>;
  images$: Observable<Image[]>;

  constructor(private route: ActivatedRoute, private store: Store<ProjectState>) {
    this.project$ = this.store.select(selectProject);
    this.images$ = this.store.select(selectImages);
  }

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.store.dispatch(new GetProject(id));
    this.store.dispatch(new GetImages(id));
  }

  trackByImageFn(index, item: Image) {
    return item.id; // unique id corresponding to the item
  }
}
