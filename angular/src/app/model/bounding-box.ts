export class BoundingBox {
  private _fromX: number;
  private _fromY: number;
  private _toX: number;
  private _toY: number;


  constructor(fromX: number, fromY: number, toX: number, toY: number) {
    this._fromX = fromX;
    this._fromY = fromY;
    this._toX = toX;
    this._toY = toY;
  }


  get fromX(): number {
    return this._fromX;
  }

  set fromX(value: number) {
    this._fromX = value;
  }

  get fromY(): number {
    return this._fromY;
  }

  set fromY(value: number) {
    this._fromY = value;
  }

  get toX(): number {
    return this._toX;
  }

  set toX(value: number) {
    this._toX = value;
  }

  get toY(): number {
    return this._toY;
  }

  set toY(value: number) {
    this._toY = value;
  }

  public printString(): string {
    return 'From (' + this.fromX + ', ' + this.fromY + '), to (' + this.toX + ', ' + this.toY + ')';
  }
}
