import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TextRegionAgnosticRepresentationComponent } from './text-region-agnostic-representation.component';

describe('TextRegionAgnosticRepresentationComponent', () => {
  let component: TextRegionAgnosticRepresentationComponent;
  let fixture: ComponentFixture<TextRegionAgnosticRepresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TextRegionAgnosticRepresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TextRegionAgnosticRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
