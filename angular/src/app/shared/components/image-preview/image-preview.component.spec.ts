import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ImagePreviewComponent } from './image-preview.component';

describe('ImagePreviewComponent', () => {
  let component: ImagePreviewComponent;
  let fixture: ComponentFixture<ImagePreviewComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ImagePreviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagePreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
