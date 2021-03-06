import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentAnalysisToolbarComponent } from './document-analysis-toolbar.component';

describe('DocumentAnalysisToolbarComponent', () => {
  let component: DocumentAnalysisToolbarComponent;
  let fixture: ComponentFixture<DocumentAnalysisToolbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentAnalysisToolbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentAnalysisToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
