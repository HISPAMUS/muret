import {Component, OnInit, Self} from '@angular/core';
import {ProjectsService} from '../../projects.service';
import {Project} from '../../../../shared/entities/project';
import {Permissions} from '../../../../shared/entities/permissions';
import {Observable} from 'rxjs';
import {User} from '../../../../shared/entities/user';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css'],
  providers: [ProjectsService] // this service is not a singleton
})

export class ProjectsComponent implements OnInit {
  user$: Observable<User>;

  constructor(@Self() private projectsService: ProjectsService) {
  }

  ngOnInit(): void {
    this.user$ = this.projectsService.user$;
  }

  trackByProjectFn(index, item: Project) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }

}
