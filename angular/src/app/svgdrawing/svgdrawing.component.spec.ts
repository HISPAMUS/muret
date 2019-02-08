import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SVGDrawingComponentComponent } from './svgdrawing.component';

describe('SVGDrawingComponentComponent', () => {
  let component: SVGDrawingComponentComponent;
  let fixture: ComponentFixture<SVGDrawingComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SVGDrawingComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SVGDrawingComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
