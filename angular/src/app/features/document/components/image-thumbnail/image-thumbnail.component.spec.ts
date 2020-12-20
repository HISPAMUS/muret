import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ImageThumbnailComponent } from './image-thumbnail.component';

describe('ImageThumbnailComponent', () => {
  let component: ImageThumbnailComponent;
  let fixture: ComponentFixture<ImageThumbnailComponent>;

  beforeEach(waitForAsync(() => {
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
