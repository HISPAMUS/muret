import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImagePhasesComponent } from './image-phases.component';

describe('DocumentPhasesComponent', () => {
  let component: ImagePhasesComponent;
  let fixture: ComponentFixture<ImagePhasesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImagePhasesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImagePhasesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
