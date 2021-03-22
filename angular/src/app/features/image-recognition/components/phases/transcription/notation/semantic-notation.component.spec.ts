import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { SemanticNotationComponent } from './semantic-notation.component';

describe('NotationComponent', () => {
  let component: SemanticNotationComponent;
  let fixture: ComponentFixture<SemanticNotationComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ SemanticNotationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SemanticNotationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
