import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NGXLogger} from 'ngx-logger';
import {environment} from '../../environments/environment';
import {AuthService} from './auth.service';
import {DialogsService} from './dialogs.service';
import {Observable} from 'rxjs';
import {RegionType} from '../model/region-type';
import {catchError} from 'rxjs/operators';
import {Project} from '../model/project';
import {User} from '../model/user';
import {ProjectURLS} from '../model/project-urls';
import {StringBody} from '../payloads/string-body';
import {ProjectStatistics} from '../model/project-statistics';
import {StringReponse} from '../string-reponse';
import {RestClientService} from "./rest-client.service";
import {SessionDataService} from "./session-data.service";
import {State} from "../model/state";

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private urlProject: string;

  constructor(private restClientService: RestClientService,
      private sessionDataService: SessionDataService,
      private logger: NGXLogger) {
    this.urlProject = environment.apiEndpoint + '/project';
  }

  /**
   * It returns an observable array of lazily loaded projects
   */
  public getProjects$(): Observable<Project[]> {
    return this.restClientService.httpGet$<Project[]>(this.urlProject, 'Fetching all projects (lazy)');
  }

  /**
   * Post a new project
   * @param name
   * @param composer
   * @param notationType
   * @param manuscriptType
   * @param comments
   * @param base64Thumbnail
   */
  public newProject$(name: string, composer: string, notationType: string, manuscriptType: string, comments: string,
                     base64Thumbnail: string): Observable<Project> {
    return this.restClientService.httpPost<Project>(this.urlProject + '/new/',
      {
      'name': name,
      'composer': composer,
      'notationType': notationType,
      'manuscriptType': manuscriptType,
      'comments': comments,
      'createdBy': {
          'id': this.sessionDataService.user.id
      },
      'thumbnailBase64Encoding': base64Thumbnail
    },
      'Creating new project with name ' + name);
  }

  /**
   * It retrieves eagerly the project
   * @param id
   */
  public getProject$(id: number): Observable<Project> {
    return this.restClientService.httpGet$(this.urlProject + '/get/' + id,
      'Fetching project with id ' + id);
  }

  /**
   * It retrieves the project statistics
   * @param id
   */
  public getProjectStatistics$(id: number): Observable<ProjectStatistics> {
    return this.restClientService.httpGet$(this.urlProject + '/statistics/' + id,
      'Fetching project statistics for id ' + id);
  }

  /**
   * It puts a project update
   * @param project
   */
  public updateProject(project: Project): Observable<any> {
    this.logger.debug('IM3WSService: saving project with id: ' + project.id);
    return this.restClientService.httpPut(this.urlProject, project,
      'Updating project with id ' + project.id);
  }

  /**
   * It just updates the project composer
   * @param project
   */
  public saveProjectComposer(project: Project, composer: string) {
    const stringBody = new StringBody(composer);
    this.restClientService.httpPut(this.urlProject + '/composer/' + project.id, stringBody,
      'Updating project composer of project with id ' + project.id)
      .subscribe(next => project.composer = composer); // if correctly changed
  }

  /**
   * It just updates the project comments
   * @param project
   */
  public saveProjectComments(project: Project, comments: string) {
    const stringBody = new StringBody(comments);
    return this.restClientService.httpPut(this.urlProject + '/comments/' + project.id, stringBody,
      'Updating project comments of project with id ' + project.id)
      .subscribe(next => project.comments = comments); // if correctly changed
  }

  /**
   * It just updates the project state
   * @param project
   */
  public saveProjectState(project: Project, value: string) {
    let state: State;
    if (value === 'none') {
      state = null;
    } else {
      if (project.state == null) {
        state = new State();
      } else {
        state = project.state;
      }
      state.state = value;
    }

    return this.restClientService.httpPut(this.urlProject + '/state/' + project.id, state,
      'Updating project state of project with id ' + project.id).subscribe(
        next => project.state = state // if correctly changed
    );
  }
}
