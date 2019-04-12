import {Entity} from './entity';

export interface TrainingSetExporter extends Entity {
  name: string;
  description: string;
  adminPermissionRequired: boolean;
}
