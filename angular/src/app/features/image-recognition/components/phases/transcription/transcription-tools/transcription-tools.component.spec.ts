import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranscriptionToolsComponent } from './transcription-tools.component';

describe('TranscriptionToolsComponent', () => {
  let component: TranscriptionToolsComponent;
  let fixture: ComponentFixture<TranscriptionToolsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TranscriptionToolsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TranscriptionToolsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
