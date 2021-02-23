import {Part} from "../../../core/model/entities/part";
import {Page} from "../../../core/model/entities/page";

export interface ImageOverview {
  imageID: number;
  documentID: number;
  documentPath: string;
  //documentParts: Part[];
}
