import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicAgnosticRepresentationComponent } from './music-agnostic-representation.component';

describe('MusicAgnosticRepresentationComponent', () => {
  let component: MusicAgnosticRepresentationComponent;
  let fixture: ComponentFixture<MusicAgnosticRepresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MusicAgnosticRepresentationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicAgnosticRepresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
