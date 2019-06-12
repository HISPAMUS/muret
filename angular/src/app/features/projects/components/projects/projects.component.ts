import {Component, OnDestroy, OnInit, Self} from '@angular/core';
import {Project} from '../../../../core/model/entities/project';
import {Permissions} from '../../../../core/model/entities/permissions';
import {Observable} from 'rxjs';
import {Store} from '@ngrx/store';
import {Collection} from '../../../../core/model/entities/collection';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {GetCollection} from '../../store/actions/projects.actions';
import {selectCollection} from '../../store/selectors/projects.selector';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
})

export class ProjectsComponent implements OnInit, OnDestroy {
  collection$: Observable<Collection>;
  collectionID: number;

  constructor(private route: ActivatedRoute, private store: Store<any>) {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.collectionID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetCollection(this.collectionID));
    });

    this.collection$ = store.select(selectCollection);
  }

  ngOnInit(): void {
  }

  trackByProjectFn(index, item: Project) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }


  ngOnDestroy(): void {
  }
}
