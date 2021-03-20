import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagePhaseComponent } from './image-phase.component';

describe('ImagePhaseComponent', () => {
  let component: ImagePhaseComponent;
  let fixture: ComponentFixture<ImagePhaseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagePhaseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagePhaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
