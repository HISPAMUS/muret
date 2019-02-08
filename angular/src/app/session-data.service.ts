import { Injectable } from '@angular/core';
import {Project} from './model/project';
import {Image} from './model/image';
import {RegionType} from './model/region-type';

@Injectable({
  providedIn: 'root'
})

export class SessionDataService {
  private _currentProject: Project;
  private _currentImage: Image;
  private _currentImageMastersURL: string;
  private _regionTypes: RegionType[];
  // private regionTypeColors: Map<number, string>;

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

  get currentImageMastersURL(): string {
    return this._currentImageMastersURL;
  }

  set currentImageMastersURL(value: string) {
    this._currentImageMastersURL = value;
  }


  get regionTypes(): RegionType[] {
    return this._regionTypes;
  }

  set regionTypes(value: RegionType[]) {
    this._regionTypes = value;
    /*this.regionTypeColors = new Map();
    value.forEach(region => {
      this.regionTypeColors.set(region.id, region.hexargb);
    });*/
  }

  /*getRegionTypeColor(id: number): string {
    return this.regionTypeColors.get(id);
  }*/
}
