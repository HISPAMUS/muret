import {Component, OnDestroy, OnInit} from '@angular/core';
import {DocumentOverviewComponent} from "../../document-overview/document-overview.component";

@Component({
  selector: 'app-document-compilation',
  templateUrl: './document-compilation.component.html',
  styleUrls: ['./document-compilation.component.css']
})
export class DocumentCompilationComponent extends DocumentOverviewComponent {

  ngOnInit(): void {
    super.ngOnInit();
  }

  ngOnDestroy(): void {
    super.ngOnDestroy();

  }

}
