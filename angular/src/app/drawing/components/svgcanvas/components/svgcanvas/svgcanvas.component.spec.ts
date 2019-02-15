import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SVGCanvasComponent } from './svgcanvas.component';

describe('SVGCanvasComponent', () => {
  let component: SVGCanvasComponent;
  let fixture: ComponentFixture<SVGCanvasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SVGCanvasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SVGCanvasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
