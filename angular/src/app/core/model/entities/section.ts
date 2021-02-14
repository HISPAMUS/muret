import {Entity} from './entity';
import {Image} from "./image";
import {IOrdered} from "./iordered";

export interface Section extends Entity, IOrdered {
  documentPath?: string; // obtained through ISectionProjection for the ReorderImagesComponent
  documentId?: number;// obtained through ISectionProjection for the ReorderImagesComponent
  name: string;
  images: Image[];
}




