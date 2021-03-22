import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SemanticKernMensGridComponent } from './semantic-kern-mens-grid.component';

describe('SemanticKernMensGridComponent', () => {
  let component: SemanticKernMensGridComponent;
  let fixture: ComponentFixture<SemanticKernMensGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SemanticKernMensGridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SemanticKernMensGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
