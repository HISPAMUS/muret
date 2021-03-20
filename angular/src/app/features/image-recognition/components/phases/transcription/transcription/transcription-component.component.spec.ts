import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranscriptionComponentComponent } from './transcription-component.component';

describe('TranscriptionComponentComponent', () => {
  let component: TranscriptionComponentComponent;
  let fixture: ComponentFixture<TranscriptionComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TranscriptionComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TranscriptionComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
