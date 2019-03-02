export interface BoundingBox {
  id?: number; // we may associate to a symbol, region or page
  fromX: number;
  fromY: number;
  toX: number;
  toY: number;
}
