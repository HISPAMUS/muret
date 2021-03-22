import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MEIPreviewComponent } from './meipreview.component';

describe('MEIPreviewComponent', () => {
  let component: MEIPreviewComponent;
  let fixture: ComponentFixture<MEIPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MEIPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MEIPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
