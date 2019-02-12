import { Injectable } from '@angular/core';
import {Project} from '../model/project';
import {Image} from '../model/image';
import {RegionType} from '../model/region-type';
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})

export class SessionDataService {
  private _user: User;
  private _currentProject: Project;
  private _currentImage: Image;
  private _regionTypes: RegionType[];

  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
    if (value == null) {
      this._currentProject = null;
      this._currentImage = null;
    }
  }

  get currentProject(): Project {
    return this._currentProject;
  }

  set currentProject(value: Project) {
    this._currentProject = value;
  }

  get currentImage(): Image {
    return this._currentImage;
  }

  set currentImage(value: Image) {
    this._currentImage = value;
  }

  get regionTypes(): RegionType[] {
    return this._regionTypes;
  }

  set regionTypes(value: RegionType[]) {
    this._regionTypes = value;
  }

  /**
   * It replaces the user lazily loaded project for the one as parameter
   * @param loadedProject
   */
  public loadProject(loadedProject: Project) {
    const newLoadedProject = Object.assign(new Project(), loadedProject);

    let itemIndex = this._user.projectsCreated.findIndex(item => item.id == loadedProject.id);
    if (itemIndex != -1) {
      this.currentProject = this._user.projectsCreated[itemIndex] = newLoadedProject;
    } else {
      let itemIndex = this._user.permissions.findIndex(item => item.project.id == loadedProject.id);
      if (itemIndex != -1) {
        this.currentProject = this._user.permissions[itemIndex].project = newLoadedProject;
      } else {
        throw new Error('Cannot find a project with id=' + loadedProject.id);
      }
    }
  }
}
