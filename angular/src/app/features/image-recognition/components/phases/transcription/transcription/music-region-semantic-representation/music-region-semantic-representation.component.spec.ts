import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicRegionSemanticRepresentationComponent } from './music-region-semantic-representation.component';

describe('MusicRegionSemanticRepresentationComponent', () => {
  let component: MusicRegionSemanticRepresentationComponent;
  let fixture: ComponentFixture<MusicRegionSemanticRepresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MusicRegionSemanticRepresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicRegionSemanticRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
