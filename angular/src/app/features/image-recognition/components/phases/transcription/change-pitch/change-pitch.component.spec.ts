import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangePitchComponent } from './change-pitch.component';

describe('ChangePitchComponent', () => {
  let component: ChangePitchComponent;
  let fixture: ComponentFixture<ChangePitchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangePitchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangePitchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
