import {Part} from "../entities/part";

export interface ImageOverview {
  imageID: number;
  documentID: number;
  documentPath: string;
  comments: string;
  documentParts: Part[]; // already sorted in Spring controller
}
