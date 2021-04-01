import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentCompilationComponent } from './document-compilation.component';

describe('DocumentCompilationComponent', () => {
  let component: DocumentCompilationComponent;
  let fixture: ComponentFixture<DocumentCompilationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentCompilationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentCompilationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
