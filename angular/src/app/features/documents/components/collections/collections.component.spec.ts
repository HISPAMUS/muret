import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { CollectionsComponent } from './collections.component';

describe('CollectionsComponent', () => {
  let component: CollectionsComponent;
  let fixture: ComponentFixture<CollectionsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ CollectionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CollectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
