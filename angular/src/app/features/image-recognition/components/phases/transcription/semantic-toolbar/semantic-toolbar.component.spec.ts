import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SemanticToolbarComponent } from './semantic-toolbar.component';

describe('SemanticToolbarComponent', () => {
  let component: SemanticToolbarComponent;
  let fixture: ComponentFixture<SemanticToolbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SemanticToolbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SemanticToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
