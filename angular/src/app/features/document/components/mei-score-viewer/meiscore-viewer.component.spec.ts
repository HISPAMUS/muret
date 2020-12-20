import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MEIScoreViewerComponent } from './meiscore-viewer.component';

describe('MEIScoreViewerComponent', () => {
  let component: MEIScoreViewerComponent;
  let fixture: ComponentFixture<MEIScoreViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MEIScoreViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MEIScoreViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
