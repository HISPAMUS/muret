import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageRecognitionToolbarComponent } from './image-recognition-toolbar.component';

describe('ImageRecognitionToolbarComponent', () => {
  let component: ImageRecognitionToolbarComponent;
  let fixture: ComponentFixture<ImageRecognitionToolbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageRecognitionToolbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageRecognitionToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
