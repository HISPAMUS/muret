import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PAECPreviewComponent } from './paecpreview.component';

describe('PAECPreviewComponent', () => {
  let component: PAECPreviewComponent;
  let fixture: ComponentFixture<PAECPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PAECPreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PAECPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
