import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageDocumentAnalysisNavigatorComponent } from './image-document-analysis-navigator.component';

describe('ImageDocumentAnalysisNavigatorComponent', () => {
  let component: ImageDocumentAnalysisNavigatorComponent;
  let fixture: ComponentFixture<ImageDocumentAnalysisNavigatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageDocumentAnalysisNavigatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageDocumentAnalysisNavigatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
