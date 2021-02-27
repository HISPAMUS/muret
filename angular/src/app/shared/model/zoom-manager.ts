export class ZoomManager {
  private _zoomFactor: number = 1;

  public zoomIn() {
    this._zoomFactor += 0.2;
  }

  public zoomOut() {
    if (this._zoomFactor > 0.2) {
      this._zoomFactor -= 0.2;
    }
  }

  //TODO Now we are attaching this to fit
  public resetZoom() {
    this._zoomFactor = 1;
  }

  get zoomFactor(): number {
    return this._zoomFactor;
  }
}
