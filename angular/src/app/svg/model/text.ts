import {Shape} from './shape';

type onClickType = () => void;

export class Text extends Shape {
  text: string;
  fontSize: number; // 10 default value
  onClick: onClickType; // use it from the client as: staffText.onClick = () => this.openSemanticRegion(staff.imageID, staff.id);

  constructor() {
    super('Text');
    this.fontSize = 10;
  }
}
