import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TrainingSetsComponent } from './training-sets.component';

describe('TrainingSetsComponent', () => {
  let component: TrainingSetsComponent;
  let fixture: ComponentFixture<TrainingSetsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainingSetsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainingSetsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
