import {Image} from './image';
import {State} from './state';
import {NGXLogger} from "ngx-logger";

export class Project {
  id: number;
  name: string;
  path: string;
  thumbnailBase64Encoding: string;
  images: Array<Image>;
  comments: string;
  imagesOrdering: string;
  notationType: string;
  manuscriptType: string;
  state: State;
  composer: string;

  /*constructor(id: number, name: string, path: string, comments: string, thumbnailBase64Encoding: string, imagesOrdering: string,
              images: Array<Image>) {
    this.id = id;
    this.name = name;
    this.path = path;
    this.thumbnailBase64Encoding = thumbnailBase64Encoding;
    this.comments = comments;
    this.imagesOrdering = imagesOrdering;
    this.orderImageArray();
  }*/

  orderImageArray() {
    if (this.images) {
      // first insert input images in a map
      const imagesMap: Map<number, Image> = new Map<number, Image>();
      this.images.forEach(image => {
        imagesMap.set(image.id, image);
      });

      const newImages = new Array<Image>();
      // insert images as appear on the imagesOrdering
      if (this.imagesOrdering) {
        this.images = new Array<Image>();
        const imageOrders = this.imagesOrdering.split(',');
        imageOrders.forEach(order => {
          const imageId = Number(order);
          const image = imagesMap.get(imageId);
          if (image) { // if not something may go wrong but it is not important here
            newImages.push(image);
            imagesMap.delete(imageId);
          }
        });
      } else {
        this.imagesOrdering = '';
      }

      // now insert the other images not inserted yet
      imagesMap.forEach((value: Image, key: number) => {
        if (this.imagesOrdering.length > 0) {
          this.imagesOrdering += ',';
        }
        this.imagesOrdering += key;
        newImages.push(value);
      });
      this.images = newImages;
    }
  }
}
