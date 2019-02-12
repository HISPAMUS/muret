import { Component, OnInit } from '@angular/core';
import {Project} from '../model/project';
import {NGXLogger} from 'ngx-logger';
import {Permissions} from '../model/permissions';
import {SessionDataService} from "../services/session-data.service";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})

export class ProjectsComponent implements OnInit {
  myProjects: Array<Project>;
  permissions: Permissions;

  constructor(private sessionDataService: SessionDataService, private logger: NGXLogger) {
  }

  ngOnInit() {
    this.myProjects = this.sessionDataService.user.projectsCreated;
    this.permissions = this.sessionDataService.user.permissions;
  }

  trackByProjectFn(index, item: Project) {
    return item.id; // unique id corresponding to the item
  }

  trackByPermissionFn(index, item: Permissions) {
    return item.id; // unique id corresponding to the item
  }
}
