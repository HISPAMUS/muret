import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreviousImageComponent } from './previous-image.component';

describe('PreviousImageComponent', () => {
  let component: PreviousImageComponent;
  let fixture: ComponentFixture<PreviousImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreviousImageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreviousImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
