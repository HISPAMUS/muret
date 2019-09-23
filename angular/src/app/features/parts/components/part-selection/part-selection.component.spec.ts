import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartSelectionComponent } from './part-selection.component';

describe('PartSelectionComponent', () => {
  let component: PartSelectionComponent;
  let fixture: ComponentFixture<PartSelectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartSelectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
