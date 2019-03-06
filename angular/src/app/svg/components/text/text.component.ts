import {Component, Input, OnInit} from '@angular/core';
import {ShapeComponent} from '../shape/shape.component';
import {Text} from '../../model/text';

@Component({
  selector: '[appText]',
  templateUrl: './text.component.html',
  styleUrls: ['./text.component.css']
})
export class TextComponent extends ShapeComponent implements OnInit {
  @Input() appText: Text;
  constructor() {
    super();
  }

  ngOnInit() {
    this.shape = this.appText;
  }

}
