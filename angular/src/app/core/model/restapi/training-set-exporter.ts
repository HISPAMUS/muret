import {Entity} from '../entities/entity';

export interface TrainingSetExporter extends Entity {
  name: string;
  description: string;
  adminPermissionRequired: boolean;
}
