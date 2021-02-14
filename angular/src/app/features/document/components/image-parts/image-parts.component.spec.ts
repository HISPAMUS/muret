import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagePartsComponent } from './image-parts.component';

describe('ImagePartsComponent', () => {
  let component: ImagePartsComponent;
  let fixture: ComponentFixture<ImagePartsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagePartsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagePartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
