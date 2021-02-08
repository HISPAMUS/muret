import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DocumentComponentOld } from './document-component-old.component';

describe('DocumentComponent', () => {
  let component: DocumentComponentOld;
  let fixture: ComponentFixture<DocumentComponentOld>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentComponentOld ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentComponentOld);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
