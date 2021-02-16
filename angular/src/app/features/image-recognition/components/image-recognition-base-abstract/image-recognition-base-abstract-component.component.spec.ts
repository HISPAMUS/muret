import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageRecognitionBaseAbstractComponent } from './image-recognition-base-abstract.component';

describe('ImageRecognitionBaseAbstractComponentComponent', () => {
  let component: ImageRecognitionBaseAbstractComponent;
  let fixture: ComponentFixture<ImageRecognitionBaseAbstractComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageRecognitionBaseAbstractComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageRecognitionBaseAbstractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
