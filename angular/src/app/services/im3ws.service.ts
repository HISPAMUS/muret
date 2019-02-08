import { Injectable } from '@angular/core';
import {NGXLogger} from 'ngx-logger';
import {AgnosticService} from './agnostic.service';
import {ClassifierService} from './classifier.service';
import {ImageService} from './image.service';
import {ProjectService} from './project.service';
import {RegionService} from './region.service';
import {SymbolService} from './symbol.service';
import {AuthService} from './auth.service';
import {TrainingSetService} from './training-set.service';

@Injectable({
  providedIn: 'root'
})

/**
 * This class has access to the IM3WS server, it includes the auth service
 * It acts as a façade to all IM3WS services
 */
export class Im3wsService {

  constructor(
    private logger: NGXLogger,
    private _agnosticService: AgnosticService,
    private _classifierService: ClassifierService,
    private _imageService: ImageService,
    private _projectService: ProjectService,
    private _regionService: RegionService,
    private _symbolService: SymbolService,
    private _authService: AuthService,
    private _trainingSetService: TrainingSetService
  ) {
    this.logger.info('Creating Im3wsService');
  }


  get agnosticService(): AgnosticService {
    return this._agnosticService;
  }

  get classifierService(): ClassifierService {
    return this._classifierService;
  }

  get imageService(): ImageService {
    return this._imageService;
  }

  get projectService(): ProjectService {
    return this._projectService;
  }

  get regionService(): RegionService {
    return this._regionService;
  }

  get symbolService(): SymbolService {
    return this._symbolService;
  }

  get authService(): AuthService {
    return this._authService;
  }

  get trainingSetService(): TrainingSetService {
    return this._trainingSetService;
  }
}
