import {Entity} from "./entity";

export interface ImageRecognitionProgressStatus extends Entity {
  phase: string;
  status: string;
}
