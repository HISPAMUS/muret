import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageToolBarComponent } from './image-tool-bar.component';

describe('ImageToolBarComponent', () => {
  let component: ImageToolBarComponent;
  let fixture: ComponentFixture<ImageToolBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImageToolBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageToolBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
