import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NextImageComponent } from './next-image.component';

describe('NextImageComponent', () => {
  let component: NextImageComponent;
  let fixture: ComponentFixture<NextImageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NextImageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NextImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
