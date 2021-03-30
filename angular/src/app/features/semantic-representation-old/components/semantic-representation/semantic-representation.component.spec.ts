import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { SemanticRepresentationComponent } from './semantic-representation.component';

describe('SemanticRepresentationComponent', () => {
  let component: SemanticRepresentationComponent;
  let fixture: ComponentFixture<SemanticRepresentationComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ SemanticRepresentationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SemanticRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});