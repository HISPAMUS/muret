import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {NotationService} from '../../services/notation.service';
import {Notation} from '../../services/notation';

// Verovio integration based on the code in https://github.com/deanmalone/PianoPlay
@Component({
  selector: 'app-notation',
  templateUrl: './notation.component.html',
  styleUrls: ['./notation.component.css']
})
export class NotationComponent implements OnInit, OnChanges {
  @Input() notation: Notation;
  notationAsSVG: any;

  constructor(private notationService: NotationService) { }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.notation) {
      // TODO ¿se llama dos veces?
      if (this.notation.notationResponseType === 'mei') {
        this.notationAsSVG = this.notationService.renderStaff(this.notation.content);
      } else if (this.notation.notationResponseType === 'svg') {
        this.notationAsSVG = this.notation.content;
      } else {
        throw new Error('Unsupported notation type: ' + this.notation.notationResponseType);
      }
    }
  }

}
