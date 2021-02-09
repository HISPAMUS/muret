import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentThumbnailComponent } from './document-thumbnail.component';

describe('DocumentThumbnailComponent', () => {
  let component: DocumentThumbnailComponent;
  let fixture: ComponentFixture<DocumentThumbnailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentThumbnailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentThumbnailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
