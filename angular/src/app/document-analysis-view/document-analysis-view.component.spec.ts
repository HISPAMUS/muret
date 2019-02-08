import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentAnalysisViewComponent } from './document-analysis-view.component';

describe('DocumentAnalysisViewComponent', () => {
  let component: DocumentAnalysisViewComponent;
  let fixture: ComponentFixture<DocumentAnalysisViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentAnalysisViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentAnalysisViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
