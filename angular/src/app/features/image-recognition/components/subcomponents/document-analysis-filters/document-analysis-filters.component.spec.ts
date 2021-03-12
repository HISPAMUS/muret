import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentAnalysisFiltersComponent } from './document-analysis-filters.component';

describe('DocumentAnalysisFiltersComponent', () => {
  let component: DocumentAnalysisFiltersComponent;
  let fixture: ComponentFixture<DocumentAnalysisFiltersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentAnalysisFiltersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentAnalysisFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
