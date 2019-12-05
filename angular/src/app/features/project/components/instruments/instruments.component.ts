import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Store} from '@ngrx/store';
import {ProjectState} from '../../store/state/project.state';
import {DialogsService} from '../../../../shared/services/dialogs.service';
import {selectImages, selectProject, selectProjectStatistics} from '../../store/selectors/project.selector';
import {GetImages, GetProject, GetProjectStatistics} from '../../store/actions/project.actions';
import {ActivateLink} from '../../../../breadcrumb/store/actions/breadcrumbs.actions';
import {Observable} from 'rxjs';
import {Project} from '../../../../core/model/entities/project';
import {Image} from '../../../../core/model/entities/image';
import {Part} from '../../../../core/model/entities/part';

@Component({
  selector: 'app-instruments',
  templateUrl: './instruments.component.html',
  styleUrls: ['./instruments.component.css']
})
export class InstrumentsComponent implements OnInit {
  project$: Observable<Project>;
  private projectID: number;

  constructor(private route: ActivatedRoute, private store: Store<ProjectState>, private router: Router,
              private dialogsService: DialogsService) {
    this.project$ = this.store.select(selectProject);
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.projectID = +this.route.snapshot.paramMap.get('id'); // + converts the string to number
      this.store.dispatch(new GetProject(this.projectID));
    });
  }

  trackByPartFn(index, item: Part) {
    return item.id; // unique id corresponding to the item
  }
}
