/**
 * Used as a means to cache the already loaded images
 */
export interface ImageBlobs {
  image_id: number;
  thumbnail: Blob;
  preview: Blob;
  master: Blob;
}
