import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentAnalysisClassifiersComponent } from './document-analysis-classifiers.component';

describe('DocumentAnalysisClassifiersComponent', () => {
  let component: DocumentAnalysisClassifiersComponent;
  let fixture: ComponentFixture<DocumentAnalysisClassifiersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentAnalysisClassifiersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentAnalysisClassifiersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
