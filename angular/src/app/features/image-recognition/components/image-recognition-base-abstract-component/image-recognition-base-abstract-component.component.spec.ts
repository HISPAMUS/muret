import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageRecognitionBaseAbstractComponentComponent } from './image-recognition-base-abstract-component.component';

describe('ImageRecognitionBaseAbstractComponentComponent', () => {
  let component: ImageRecognitionBaseAbstractComponentComponent;
  let fixture: ComponentFixture<ImageRecognitionBaseAbstractComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageRecognitionBaseAbstractComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageRecognitionBaseAbstractComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
