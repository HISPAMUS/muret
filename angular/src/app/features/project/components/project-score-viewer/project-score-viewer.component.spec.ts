import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectScoreViewerComponent } from './project-score-viewer.component';

describe('ProjectScoreViewerComponent', () => {
  let component: ProjectScoreViewerComponent;
  let fixture: ComponentFixture<ProjectScoreViewerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectScoreViewerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectScoreViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
