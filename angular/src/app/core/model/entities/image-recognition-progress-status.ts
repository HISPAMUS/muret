import {Entity} from "./entity";
import {ImageRecognitionPhase} from "./image-recognition-phase";

export interface ImageRecognitionProgressStatus extends Entity {
  imageRecognitionPhase: ImageRecognitionPhase;
  status: 'hidden' | 'working' | 'done';
}
