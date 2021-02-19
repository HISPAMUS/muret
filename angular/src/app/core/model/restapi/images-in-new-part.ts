import {PartsInImage} from "./parts-in-image";
import {Part} from "../entities/part";

export interface ImagesInNewPart {
  partsInImage: PartsInImage[];
  part: Part;
}
