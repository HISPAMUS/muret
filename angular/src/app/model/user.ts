import {Project} from './project';
import {Permissions} from './permissions';

export class User {
  private _id: number;
  private _username: string;
  private _projectsCreated: Array<Project>;
  private _permissions: Array<Permissions>;


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get username(): string {
    return this._username;
  }

  set username(value: string) {
    this._username = value;
  }

  get projectsCreated(): Array<Project> {
    return this._projectsCreated;
  }

  set projectsCreated(value: Array<Project>) {
    this._projectsCreated = value;
  }

  get permissions(): Array<Permissions> {
    return this._permissions;
  }

  set permissions(value: Array<Permissions>) {
    this._permissions = value;
  }
}
