import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentIncipitsComponent } from './document-incipits.component';

describe('DocumentIncipitsComponent', () => {
  let component: DocumentIncipitsComponent;
  let fixture: ComponentFixture<DocumentIncipitsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentIncipitsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentIncipitsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
