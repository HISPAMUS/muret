import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegionPreviewComponent } from './region-preview.component';

describe('RegionPreviewComponent', () => {
  let component: RegionPreviewComponent;
  let fixture: ComponentFixture<RegionPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegionPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegionPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
