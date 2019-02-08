import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageThumbnailComponent } from './image-thumbnail.component';

describe('ImageThumbnailComponent', () => {
  let component: ImageThumbnailComponent;
  let fixture: ComponentFixture<ImageThumbnailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageThumbnailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageThumbnailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
