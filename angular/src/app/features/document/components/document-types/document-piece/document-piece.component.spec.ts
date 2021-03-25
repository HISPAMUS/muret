import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentPieceComponent } from './document-piece.component';

describe('DocumentComponent', () => {
  let component: DocumentPieceComponent;
  let fixture: ComponentFixture<DocumentPieceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentPieceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentPieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
