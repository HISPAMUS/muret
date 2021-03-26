import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImageShowHideComponent } from './image-show-hide.component';

describe('ImageShowHideComponent', () => {
  let component: ImageShowHideComponent;
  let fixture: ComponentFixture<ImageShowHideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImageShowHideComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImageShowHideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
