import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReorderImagesComponent } from './reorder-images.component';

describe('ReorderImagesComponent', () => {
  let component: ReorderImagesComponent;
  let fixture: ComponentFixture<ReorderImagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReorderImagesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReorderImagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
