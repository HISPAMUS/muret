import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextRegionSemanticRepresentationComponent } from './text-region-semantic-representation.component';

describe('TextRegionSemanticRepresentationComponent', () => {
  let component: TextRegionSemanticRepresentationComponent;
  let fixture: ComponentFixture<TextRegionSemanticRepresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextRegionSemanticRepresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TextRegionSemanticRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
