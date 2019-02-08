import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FreehandComponent } from './freehand.component';

describe('FreehandComponent', () => {
  let component: FreehandComponent;
  let fixture: ComponentFixture<FreehandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FreehandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FreehandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
