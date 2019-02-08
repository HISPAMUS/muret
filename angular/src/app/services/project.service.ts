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

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private urlProject: string;

  constructor(private http: HttpClient,
              private logger: NGXLogger,
              private authService: AuthService,
              private dialogService: DialogsService) {
    this.urlProject = environment.apiEndpoint + '/project';
  }

  public getProjects$(): Observable<Project[]> {
    this.logger.debug('IM3WSService: fetching projects...');

    return this.http.get<Project[]>(this.urlProject, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getProjects$', []))
      );
  }

  public getUser$(id: number): Observable<User> {
    this.logger.debug('IM3WSService: fetching user ' + id + '...');

    return this.http.get<User>(this.urlProject + '/getlazy/' + id, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getUser$$', null))
      );
  }

  public newProject$(name: string, composer: string, notationType: string, manuscriptType: string, comments: string,
                     base64Thumbnail: string): Observable<Project> {
    this.logger.debug('IM3WSService: creating project with name ' + name);
    return this.http.post<Project>(this.urlProject + '/new', {
      'name': name,
      'composer': composer,
      'notationType': notationType,
      'manuscriptType': manuscriptType,
      'comments': comments,
      'thumbnailBase64Encoding': base64Thumbnail
    }, this.authService.getHttpAuthOptions()).pipe(
      catchError(this.dialogService.handleError('newProject$ with name=' + name, null))
    );
  }

  public getProject$(id: number): Observable<Project> {
    this.logger.debug('IM3WSService: fetching project with id ' + id);
    const result: Observable<Project> = this.http.get<Project>(this.urlProject + '/get/' + id, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getProject$ with id=' + id, null))
      );
    this.logger.debug('IM3WSService: fetched ' + result.valueOf());
    return result;
  }

  public getProjectURLs$(id: number): Observable<ProjectURLS> {
    this.logger.debug('IM3WSService: fetching thumbnail URL of project with id ' + id);
    const result: Observable<ProjectURLS> = this.http.get<ProjectURLS>(this.urlProject + '/projectURLS/' + id, this.authService.getHttpAuthOptions())
      .pipe(
        catchError(this.dialogService.handleError('getProject$ with id=' + id, null))
      );
    this.logger.debug('IM3WSService: fetched URL ' + result.valueOf());
    return result;
  }

  public saveProject(project: Project): Observable<any> {
    this.logger.debug('IM3WSService: saving project with id: ' + project.id);
    const result = this.http.put(this.urlProject, project, this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      console.log('Save project result: ' + res);
    });
    return result;
  }

  public saveProjectComposer(project: Project): Observable<any> {
    this.logger.debug('IM3WSService: saving project composer with id: ' + project.id);
    const stringBody = new StringBody(project.composer);
    const result = this.http.put(this.urlProject + '/composer/' + project.id, stringBody, this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      console.log('Save project composer result: ' + res);
    });
    return result;
  }

  public saveProjectComments(project: Project): Observable<any> {
    this.logger.debug('IM3WSService: saving project comments with id: ' + project.id);
    const stringBody = new StringBody(project.comments);
    const result = this.http.put(this.urlProject + '/comments/' + project.id, stringBody, this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      console.log('Save project comments result: ' + res);
    });
    return result;
  }

  public saveProjectState(project: Project): Observable<any> {
    this.logger.debug('IM3WSService: saving project state with id: ' + project.id);
    const result = this.http.put(this.urlProject + '/state/' + project.id, project.state, this.authService.getHttpAuthOptions());
    result.subscribe(res => {
      console.log('Save project state result: ' + res);
    });
    return result;
  }

  public getProjectStatistics$(id: number)
    : Observable<ProjectStatistics> {
    this.logger.debug('IM3WSService: fetching project statistics for id ' + id);
    return this.http.get<StringReponse>(this.urlProject + '/statistics/' + id
      ,
      this.authService.getHttpAuthOptions(),
    )
      .pipe(
        catchError(this.dialogService.handleError('getProjectStatistics$ ' + id, null))
      );
  }

}
