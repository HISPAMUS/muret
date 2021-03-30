import {Part} from "../entities/part";
import {ImageRecognitionProgressStatus} from "../entities/image-recognition-progress-status";

export interface ImageOverview {
  imageID: number;
  //imageWidth: number;
  filename: string;
  documentID: number;
  documentPath: string;
  notationType: string;
  manuscriptType: string;
  comments: string;
  hidden: boolean;
  documentParts: Part[]; // already sorted in Spring controller
  imagePart: Part;
  imageRecognitionProgressStatuses: ImageRecognitionProgressStatus[];
}
