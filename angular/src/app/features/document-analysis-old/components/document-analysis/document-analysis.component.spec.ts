import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DocumentAnalysisComponent } from './document-analysis.component';

describe('DocumentAnalysisComponent', () => {
  let component: DocumentAnalysisComponent;
  let fixture: ComponentFixture<DocumentAnalysisComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentAnalysisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentAnalysisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
