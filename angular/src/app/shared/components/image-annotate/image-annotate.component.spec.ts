import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageAnnotateComponent } from './image-annotate.component';

describe('ImageAnnotateComponent', () => {
  let component: ImageAnnotateComponent;
  let fixture: ComponentFixture<ImageAnnotateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageAnnotateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageAnnotateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
